package com.bit.opperation;

import com.bit.book.Book;
import com.bit.book.BookList;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:42
 */
public class AddOperation implements Ioopperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("添加书籍");
        System.out.println("请输入图书名字:");
        String name=sc.next();
        System.out.println("请输入图书作者:");
        String author=sc.next();
        System.out.println("请输入图书价格:");
        int price=sc.nextInt();
        System.out.println("请输入图书类型:");
        String type=sc.next();
        Book book=new Book(name,author,price,type);
        bookList.setBooks(bookList.getSize(),book);
        bookList.setSize(bookList.getSize()+1);



    }
}
