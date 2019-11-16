package com.bit.opperation;

import com.bit.book.Book;
import com.bit.book.BookList;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:43
 */
public class ReturnOperation implements Ioopperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("ReturnOperation");
        System.out.println("请输入要归还的书籍");
        String name=sc.next();
        int i=0;
        for(;i<bookList.getSize();i++) {
            if (bookList.getBook(i).name.equals(name)) {
                break;
            }
        }
        if(i>=bookList.getSize()) {
            System.out.println("没有此书");
            return;
        }
        Book book=bookList.getBook(i);
        //检查是否借出，false状态表示可以借
        if(book.isBorrowed) {
            book.isBorrowed=false;
            System.out.println("归还成功");
        }else {
            System.out.println("归还失败");
        }
    }
}
