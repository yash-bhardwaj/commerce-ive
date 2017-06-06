package com.rccl.cp.ive.it.prepare;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastax.driver.core.ProtocolOptions.Compression;

public class CassandraTestModelCreatorTestcase {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        List<String> addresses = Arrays.asList(new String[]{"localhost"});
        int port = 4000;
        Compression compression = Compression.SNAPPY;
        String username = "";
        String password = "";
        String qualifiedTableName = "";
        CassandraTestModelCreator modelCreator =
            new CassandraTestModelCreator(addresses, port, compression, username, password, qualifiedTableName);
        assertTrue(modelCreator.checkCassandraReachable());
        modelCreator.destroy();

    }

}
