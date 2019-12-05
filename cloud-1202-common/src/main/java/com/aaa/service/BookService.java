package com.aaa.service;

import com.aaa.model.BookInfo;


import java.util.List;

public interface BookService {
    /*
     * 获得所有书籍
     * */

    List<BookInfo> getAllBook();

}
