package com.bit.opperation;

import com.bit.book.BookList;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:12:04
 */
public class Exit implements Ioopperation{
    @Override
    public void work(BookList bookList) {
        System.exit(0);
        System.out.println("退出");

    }
}
