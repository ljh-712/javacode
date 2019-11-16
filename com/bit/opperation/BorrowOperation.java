package com.bit.opperation;

import com.bit.book.BookList;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:43
 */
public class BorrowOperation implements Ioopperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("BorrowOperation");
        System.out.println("输入需要借阅书籍的名称");
        String name = sc.next();
        //不会从bookList-》进行删除-》isBorrowed true
        int i = 0;
        for (; i <bookList.getSize() ; i++) {
            if (bookList.getBook(i).name.equals(name)) {
                System.out.println(bookList.getBook(i));
                break;
            }
        }

            if (i>bookList.getSize()) {
                System.out.println("该书不存在");
                return;
            }else {
                //bookList.setSize(bookList.getSize()-1);
                bookList.getBook(i).isBorrowed=true;

                System.out.println("已借阅");
                }
        }
}

