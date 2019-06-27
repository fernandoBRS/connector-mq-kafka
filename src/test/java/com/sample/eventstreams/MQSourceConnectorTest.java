package com.sample.eventstreams;

import org.apache.kafka.connect.connector.Connector;
import org.apache.kafka.connect.source.SourceConnector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MQSourceConnectorTest {
    @Test
    public void testVersion() {
        String version = new MQSourceConnector().version();
        String expectedVersion = System.getProperty("connectorVersion");
        assertEquals("Expected connector version to match version of built jar file.", expectedVersion, version);
    }

    @Test
    public void testConnectorType() {
        Connector connector = new MQSourceConnector();
        assertTrue(SourceConnector.class.isAssignableFrom(connector.getClass()));
    }
}
