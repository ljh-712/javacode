package com.bit.opperation;

import com.bit.book.Book;
import com.bit.book.BookList;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:42
 */
public class DelOperation implements Ioopperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("DelOperation");
        System.out.println("请输入要删除的书籍名");
        String name=sc.next();
        int i = 0;
        for (; i <bookList.getSize(); i++) {
            if (bookList.getBook(i).name.equals(name)) {
                break;
            }
        }
        if(i>=bookList.getSize()) {
            System.out.println("没有此书");
            return;
        }
        //开始删除
        int pos=i;
        for(int j=pos;j<bookList.getSize()-1;j++) {
            Book nextBook=bookList.getBook(j+1);
            bookList.setBooks(j,nextBook);
        }
        bookList.setSize(bookList.getSize()-1);
        System.out.println("删除成功");

    }
}
