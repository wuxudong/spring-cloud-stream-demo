package com.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RegisterSink {
    String REGISTER_SINK = "register_sink";

    @Input(REGISTER_SINK)
    SubscribableChannel registerSink();

}
