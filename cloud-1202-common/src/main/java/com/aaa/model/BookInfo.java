package com.aaa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BookInfo {
    private long bookId;
    private String bookName;
    private Integer bookStore;
    private BigDecimal bookPrice;
}
