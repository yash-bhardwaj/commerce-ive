package com.rccl.cp.ive.it.prepare;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ProtocolOptions;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.AuthenticationException;
import com.datastax.driver.core.exceptions.NoHostAvailableException;
import com.google.common.base.Joiner;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * Cassandra Destination for StreamSets Data Collector
 *
 * Some basic ground rules for the Cassandra Java Driver: - Use one cluster
 * instance per (physical) cluster (per application lifetime). - Use at most one
 * session instance per keyspace, or use a single Session and explicitly specify
 * the keyspace in your queries. - If you execute a statement more than once,
 * consider using a prepared statement. - You can reduce the number of network
 * round trips and also have atomic operations by using batches.
 *
 */
public class CassandraTestModelCreator {
    final Logger logger = LoggerFactory.getLogger(CassandraTestModelCreator.class);
    private static final int MAX_BATCH_SIZE = 65535;

    private final List<String> addresses;
    private final ProtocolOptions.Compression compression;
    private List<InetAddress> contactPoints;
    private final int port;

    private final String qualifiedTableName;

    private Cluster cluster = null;
    private Session session = null;

    private SortedMap<String, String> columnMappings;
    private LoadingCache<SortedSet<String>, PreparedStatement> statementCache;

    public CassandraTestModelCreator(final List<String> addresses, final int port,
        final ProtocolOptions.Compression compression, final String username, final String password,
        final String qualifiedTableName) {
        this.addresses = addresses;
        this.port = port;
        this.compression = compression;
        this.qualifiedTableName = qualifiedTableName;
        init(username, password);
    }

    protected void init(final String username, final String password) {

        contactPoints = new ArrayList<>(addresses.size());
        for (String address : addresses) {
            if (null == address) {
                logger.warn("A null value was passed in as a contact point.");
                // This isn't valid but InetAddress won't complain so we skip
                // this entry.
                continue;
            }

            try {
                contactPoints.add(InetAddress.getByName(address));
            } catch (UnknownHostException e) {
                logger.error("init() Got UnknownHostException: {}", e.getMessage());
            }
        }

        if (contactPoints.size() < 1) {
        }

        if (!qualifiedTableName.contains(".")) {
        } else {
            if (checkCassandraReachable()) {
            }
        }

        if (true) {
            cluster = Cluster.builder().addContactPoints(contactPoints).withCompression(compression).withPort(port)
                // If authentication is disabled on the C* cluster, this
                // method has no effect.
                .withCredentials(username, password).build();

            try {
                session = cluster.connect();

                statementCache = CacheBuilder.newBuilder()
                    // No expiration as prepared statements are good for the
                    // entire session.
                    .build(new CacheLoader<SortedSet<String>, PreparedStatement>() {
                        @Override
                        public PreparedStatement load(SortedSet<String> columns) {
                            // The INSERT query we're going to perform
                            // (parameterized).
                            SortedSet<String> statementColumns = new TreeSet<>();
                            for (String fieldPath : columnMappings.keySet()) {
                                final String fieldName = fieldPath.replaceAll("/", "");
                                if (columns.contains(fieldName)) {
                                    statementColumns.add(fieldName);
                                }
                            }
                            final String query = String.format("INSERT INTO %s (%s) VALUES (%s);",
                                qualifiedTableName, Joiner.on(", ").join(statementColumns),
                                Joiner.on(", ").join(Collections.nCopies(statementColumns.size(), "?")));
                            logger.trace("Prepared Query: {}", query);
                            return session.prepare(query);
                        }
                    });
            } catch (NoHostAvailableException e) {
                logger.error("init() Got NoHostAvailableException: {}", e.getMessage());
            } catch (AuthenticationException e) {
                logger.error("init() Got AuthenticationException: {}", e.getMessage());
            } catch (IllegalStateException e) {
                logger.error("init() Got IllegalStateException: {}", e.getMessage());
            }
        }
    }

    public void destroy() {
        try {
            if (session != null) {
                session.close();
            }
            if (cluster != null) {
                cluster.close();
            }
        } catch (Exception e) {
            logger.error("destroy() Got Exception: {}", e.getMessage());
        }
    }

    public boolean checkCassandraReachable() {
        boolean isReachable = true;
        try (Cluster cluster = getCluster()) {
            Session session = cluster.connect();
            session.close();
        } catch (NoHostAvailableException e) {
            isReachable = false;
            logger.error("checkCassandraReachable() Got NoHostAvailableException: {}", e.getMessage());
        } catch (AuthenticationException e) {
            isReachable = false;
            logger.error("checkCassandraReachable() Got AuthenticationException: {}", e.getMessage());
        } catch (IllegalStateException e) {
            isReachable = false;
            logger.error("checkCassandraReachable() Got IllegalStateException: {}", e.getMessage());
        }
        return isReachable;
    }

    public Session getSession() {
        if (session == null) {
            session = cluster.connect();
        }
        return session;
    }

    private Cluster getCluster() {
        return Cluster.builder().addContactPoints(contactPoints).withPort(port).build();
    }
}
