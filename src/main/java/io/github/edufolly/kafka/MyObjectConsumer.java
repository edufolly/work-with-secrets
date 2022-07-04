package io.github.edufolly.kafka;

import io.quarkus.logging.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Eduardo Folly
 */
@ApplicationScoped
public class MyObjectConsumer {

    @Incoming("channel-in")
    public void sink(ConsumerRecord<String, MyObject> record) {
        Log.info(record.value());
    }

}
