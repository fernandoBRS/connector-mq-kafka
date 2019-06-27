package com.sample.eventstreams.builders;

import java.util.Map;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.source.SourceRecord;

/**
 * Builds Kafka Connect SourceRecords from messages.
 */
public interface RecordBuilder {
    /**
     * Configure this class.
     * 
     * @param props initial configuration
     *
     * @throws ConnectException   Operation failed and connector should stop.
     */
    default void configure(Map<String, String> props) {}

    /**
     * Convert a message into a Kafka Connect SourceRecord.
     * 
     * @param context            the JMS context to use for building messages
     * @param topic              the Kafka topic
     * @param messageBodyJms     whether to interpret MQ messages as JMS messages
     * @param message            the message
     * 
     * @return the Kafka Connect SourceRecord
     * 
     * @throws JMSException      Message could not be converted
     */
    SourceRecord toSourceRecord(JMSContext context, String topic, boolean messageBodyJms, Message message) throws JMSException;
}
