package com.aaa.service;

import com.aaa.model.BookInfo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BookServiceHystrixImpl implements BookService{
    @Override
    public List<BookInfo> getAllBook() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("西游记");
        System.out.println("服务降级中");
        List<BookInfo> bookInfos = new LinkedList<>();
        bookInfos.add(bookInfo);
        if (bookInfos == null) {
            return null;
        }
        return bookInfos;
    }
}
