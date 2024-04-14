package org.vinaylogics.springcloudstreampublisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookPublisher bookPublisher;

    @PostMapping("/publish")
    public Book publish(@RequestBody Book book) throws JsonProcessingException {
        bookPublisher.publish(book);
        return book;
    }
}
