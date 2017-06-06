package com.rccl.cp.ive.update.readside.po;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.bind;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableMap;
import com.lightbend.lagom.internal.javadsl.api.broker.TopicFactory;
import com.lightbend.lagom.javadsl.persistence.ReadSide;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.lightbend.lagom.javadsl.testkit.ServiceTest;
import com.rccl.cp.ive.update.common.ImmutableEventLocation;
import com.rccl.cp.ive.update.common.ImmutableEventSourceDetail;
import com.rccl.cp.ive.update.common.ImmutableEventTime;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import com.rccl.cp.ive.update.dining.api.ImmutableDiningEventMessage;
import com.rccl.cp.ive.update.dining.api.impl.DiningEventProcessor;
import com.rccl.cp.ive.update.readside.utils.DoNothingTopicFactory;

import akka.actor.ActorSystem;

public class ReadsideGuestCalendarEventPersistorTest {

    private final static Map<String, Object> configurations = ImmutableMap.<String, Object>builder()
        .put("cassandra-query-journal.eventual-consistency-delay", "0")
        .put("cassandra.default.port", "4000")
        .put("lagom.persistence.read-side.cassandra.port", "4000")
        .put("cassandra-journal.port", "4000")
        .put("cassandra-snapshot-store.port", "4000")
        .build();

    private final static ServiceTest.Setup setup = defaultSetup().withCassandra(true)
        .configureBuilder(b ->
    // by default, cassandra-query-journal delays propagation of events by
    // 10sec. In test we're using
    // a 1 node cluster so this delay is not necessary.
    b.configure(configurations)
        .overrides(bind(ReadSide.class).to(DiningReadSideTestDriver.class),
            bind(TopicFactory.class).to(DoNothingTopicFactory.class)));

    private static ServiceTest.TestServer testServer;
    private static DiningEventMessage defaultMessage = ImmutableDiningEventMessage.builder()
        .shipSailDate("OA20170101")
        .cruiseBookingID("123")
        .guestID("12345")
        .eventType("DINING")
        .eventGroupType("DINING")
        .eventName("Event name")
        .eventStartTime(
            ImmutableEventTime.builder().eventDate("2018-01-01").eventTime("12:00").eventTimeZone("SHIP").build())
        .eventEndTime(
            ImmutableEventTime.builder().eventDate("2018-01-01").eventTime("12:00").eventTimeZone("SHIP").build())
        .eventGroupDescription("")
        .eventGroupType("")
        .eventLocation(ImmutableEventLocation.builder().locationCode("MIA").locationType("SEAPORT").build())
        .sourceDetail(ImmutableEventSourceDetail.builder()
            .sourceSystemApplicationID("SW")
            .sourceSystemOfferingID("TA00")
            .build())
        .build();

    private static CassandraSession leakedSessionOrNull;
    private static ActorSystem actorSystem;

    @BeforeClass
    public static void beforeAll() {
        testServer = ServiceTest.startServer(setup);
    }

    @AfterClass
    public static void afterAll() {
        testServer.stop();
    }

    private DiningReadSideTestDriver testDriver = testServer.injector().instanceOf(DiningReadSideTestDriver.class);

    private UUID creatorId = UUID.randomUUID();
    private UUID itemId = UUIDs.timeBased();
    private Optional<UUID> categoryId = Optional.empty();

    private AtomicInteger offset;

    @Before
    public void restartOffset() {
        offset = new AtomicInteger(1);
        testDriver.register(DiningEventProcessor.class);
        leakedSessionOrNull = testDriver.getCassandraSessionIfExist();
        System.out.println("Hey I got the cassandra session. " + leakedSessionOrNull);
        actorSystem = ActorSystem.create();
    }
    @After
    public void tearDown() throws Exception {
    }

    // @Test
    public void testProcessUpdateEvent() {
        ReadsideGuestCalendarEventPersistorDefaultImpl readsidePersistor =
            new ReadsideGuestCalendarEventPersistorDefaultImpl(actorSystem, leakedSessionOrNull);
        readsidePersistor.processUpdateEvent(leakedSessionOrNull, defaultMessage);
    }

}
