package com.bit.opperation;

import com.bit.book.BookList;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:43
 */
public class DisplayOperation implements Ioopperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("DisplayOperation");
        for (int i = 0; i <bookList.getSize() ; i++)
            System.out.println(bookList.getBook(i));
    }
}
