package com.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RegisterSource {
    String REGISTER_SOURCE = "register_source";

    @Output(REGISTER_SOURCE)
    MessageChannel registerSource();

}
