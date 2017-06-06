/*
 * Copyright (C) 2016-2017 Lightbend Inc. <https://www.lightbend.com>
 */
package com.rccl.cp.ive.update.cruisecompass.api.impl;

import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rccl.cp.ive.update.cruisecompass.api.StreamConsumerService;

import akka.stream.Materializer;
import play.inject.ApplicationLifecycle;

/**
 * Implementation of the async read-side processor.
 */
public class StreamConsumerServiceImpl implements StreamConsumerService {

    // private final CruiseCompassStreamService cruiseCompassProducerService;
    @SuppressWarnings("unused")
    private final Materializer materializer;
    @SuppressWarnings("unused")
    private final ApplicationLifecycle lifecycle;
    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(
        StreamConsumerServiceImpl.class);

    @Inject
    public StreamConsumerServiceImpl(final Materializer materializr,
        final ApplicationLifecycle lifecycl) {
        // this.cruiseCompassProducerService = cruiseCompassProducerService;
        this.materializer = materializr;
        this.lifecycle = lifecycl;
        lifecycl.addStopHook(() -> {
            CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
                System.out.println("========= IVE Stream Consumer Stop hook "
                    + "is invoked");
            });
            return task;
        });
        /*
         * try { //startKafkaStream(new String[0]); } catch (Exception e) { //
         * To do Auto-generated catch block
         * logger.error("StreamConsumerServiceImpl() Got exception from " +
         * "startKafkaStream(): {}", e.getMessage()); }
         */
    }

    /**
     * Not working yet - Kafka is very sensitive between versions. The Lagom
     * kafka is too old for Kafka stream. :(
     *
     * @param args
     * @throws Exception
     */
    public static void startKafkaStream(final String[] args) throws Exception {
        String bootstrapServers = "localhost:9092";
        if (args.length > 0) {
            bootstrapServers = args[0];
        }
        final Properties streamsConfiguration = new Properties();
        // Give the Streams application a unique name. The name must be
        // unique in the Kafka cluster against which the application is run.
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG,
            "map-function-lambda-example");
        // Where to find Kafka broker(s).
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
            bootstrapServers);
        // Specify default (de)serializers for record keys and values.
        streamsConfiguration.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG,
            Serdes.ByteArray().getClass().getName());
        streamsConfiguration.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG,
            Serdes.String().getClass().getName());

        // Set up serializers and deserializers, which we will use for
        // overriding the default serdes specified above.
        final Serde<String> stringSerde = Serdes.String();
        final Serde<byte[]> byteArraySerde = Serdes.ByteArray();

        // In the subsequent lines we define the processing topology of the
        // Streams application.
        final KStreamBuilder builder = new KStreamBuilder();

        // Read the input Kafka topic into a KStream instance.
        final KStream<byte[], String> textLines = builder.stream(
            byteArraySerde, stringSerde, "TextLinesTopic");

        // Variant 1: using `mapValues`
        final KStream<byte[], String> uppercasedWithMapValues =
            textLines.mapValues(String::toUpperCase);

        // Write (i.e. persist) the results to a new Kafka topic called
        // "UppercasedTextLinesTopic".
        //
        // In this case we can rely on the default serializers for keys and
        // values because their data types did not change, i.e. we only need
        // to provide the name of the output topic.
        uppercasedWithMapValues.to("UppercasedTextLinesTopic");

        // Variant 2: using `map`, modify value only (equivalent to variant 1)
        // final KStream<byte[], String> uppercasedWithMap = textLines.map((
        // key, value) -> new KeyValue<>(key, value.toUpperCase()));

        // Variant 3: using `map`, modify both key and value
        //
        // Note: Whether, in general, you should follow this artificial
        // example and store the original value in the key field is
        // debatable and depends on your use case. If in doubt, don't
        // do it.
        final KStream<String, String> originalAndUppercased = textLines.map((
            key, value) -> KeyValue.pair(value, value.toUpperCase()));

        // Write the results to a new Kafka topic "OriginalAndUppercasedTopic".
        //
        // In this case we must explicitly set the correct serializers
        // because the default serializers
        // (cf. streaming configuration) do not match the type of this
        // particular KStream instance.
        originalAndUppercased.to(stringSerde, stringSerde,
            "OriginalAndUppercasedTopic");

        final KafkaStreams streams = new KafkaStreams(builder,
            streamsConfiguration);
        // Always (and unconditionally) clean local state prior to starting
        // the processing topology.
        // We opt for this unconditional call here because this will make it
        // easier for you to play around with the example
        // when resetting the application for doing a re-run
        // (via the Application Reset Tool,
        // http://docs.confluent.io/current/streams/developer-guide.html
        // #application-reset-tool).
        //
        // The drawback of cleaning up local state prior is that your app
        // must rebuilt its local state from scratch, which
        // will take time and will require reading all the state-relevant
        // data from the Kafka cluster over the network.
        // Thus in a production scenario you typically do not want to
        // clean up always as we do here but rather only when it
        // is truly needed, i.e., only under certain conditions
        // (e.g., the presence of a command line flag for your app).
        // See `ApplicationResetExample.java` for a production-like example.
        streams.cleanUp();
        streams.start();

        // Add shutdown hook to respond to SIGTERM and gracefully close
        // Kafka Streams
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
