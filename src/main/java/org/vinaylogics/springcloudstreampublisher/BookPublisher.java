package org.vinaylogics.springcloudstreampublisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookPublisher {

    private final ObjectMapper objectMapper;

    private final StreamBridgeDelegate delegate;

    public void publish(Book book) throws JsonProcessingException {
        log.info("Publishing book {}", book);
        delegate.send("books", MessageBuilder.withPayload(objectMapper.writeValueAsString(book)).build(), MimeTypeUtils.APPLICATION_JSON);
    }


}
