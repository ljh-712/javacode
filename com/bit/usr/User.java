package com.bit.usr;

import com.bit.book.BookList;
import com.bit.opperation.Ioopperation;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:59
 */
public abstract class User {
    protected String name;
    protected Ioopperation[] operations;


    public abstract int menu();
    // 根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }
}
