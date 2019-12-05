package com.aaa.controller;

import com.aaa.model.BookInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@RestController
public class RibbonConsumerBookConroller {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod="error",commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="15000")})
    @GetMapping("getAllBookFromRibbon")
    public List<BookInfo> getAllBook(){
       LinkedList<BookInfo> forObject=restTemplate.getForObject("http://provider-server/getAllBook", LinkedList.class);
            return forObject;
    }
    public List<BookInfo> error(){
        BookInfo bookInfo=new BookInfo();
        bookInfo.setBookName("西游记");
        System.out.println("服务阻断");
        List<BookInfo> bookInfos=new LinkedList<>();
        bookInfos.add(bookInfo);
        if(bookInfos==null){
            return null;
        }
        return bookInfos;
    }
}
