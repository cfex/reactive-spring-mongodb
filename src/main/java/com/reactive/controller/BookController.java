package com.reactive.controller;

import com.reactive.domain.Book;
import com.reactive.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public @ResponseBody Flux<Book> fetchBooks() {
        log.info("Fetching data...");
        return bookRepository.findByOrderByCreatedAtDesc();
    }

    @PostMapping
    public @ResponseBody Mono<Book> persistBook(@RequestBody Mono<Book> bookMono) {
        log.info("Persisting data...");
        return bookRepository.insert(bookMono).next();
    }
}
