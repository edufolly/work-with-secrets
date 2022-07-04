package io.github.edufolly.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

/**
 * @author Eduardo Folly
 */
public class MyObjectDeserializer extends ObjectMapperDeserializer<MyObject> {

    public MyObjectDeserializer() {
        super(MyObject.class);
    }

}
