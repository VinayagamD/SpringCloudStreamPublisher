package org.vinaylogics.springcloudstreampublisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.time.Duration;
import java.time.Instant;

@Component
@Slf4j
@RequiredArgsConstructor
public class StreamBridgeDelegate {

    private final StreamBridge streamBridge;


    public boolean send(String bindingName, String binderName, Message<?> message, MimeType mimeType) {
        Instant start = Instant.now();
        try {
            return streamBridge.send(bindingName, binderName, message, mimeType);
        }finally {
            calculateExecTime(start);
        }
    }

    public boolean send(String bindingName, Message<?> message, MimeType mimeType) {
        Instant start = Instant.now();
        try {
            return streamBridge.send(bindingName, message, mimeType);
        }finally {
            calculateExecTime(start);
        }
    }



    private void calculateExecTime(Instant instant) {
        Instant endTime = Instant.now();
        Duration timeElapsed = Duration.between(instant, endTime);
        log.info("Time elapsed: {} ms", timeElapsed.toMillis());
    }
}
