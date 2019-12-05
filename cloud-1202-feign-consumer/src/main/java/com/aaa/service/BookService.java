package com.aaa.service;

import com.aaa.model.BookInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//声明为feignClient 并且连接provider-server
@FeignClient(value = "provider-server",fallback = BookServiceHystrixImpl.class)
public interface BookService {
    @GetMapping(value="/getAllBook")
    List<BookInfo> getAllBook();
}
