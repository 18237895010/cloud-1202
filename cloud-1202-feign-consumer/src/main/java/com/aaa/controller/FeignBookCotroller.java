package com.aaa.controller;

import com.aaa.model.BookInfo;
import com.aaa.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.awt.print.Book;
import java.util.List;

@RestController
public class FeignBookCotroller {
    @Autowired
    private BookService bookService;
    @HystrixCommand
    @GetMapping("feignGetAllBook")
    public List<BookInfo> getAllBook() {
        List<BookInfo> allBook = bookService.getAllBook();
        System.out.println("feign get book " + allBook.size());
        return allBook;
    }
}
