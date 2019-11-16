package com.bit;

import com.bit.book.BookList;
import com.bit.usr.Admin;
import com.bit.usr.NormalUser;
import com.bit.usr.User;

import java.util.Scanner;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:12:09
 */
public class Main {
    public static User login() {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=input.next();
        System.out.println("请选择用户类型:0为管理员，1为普通用户");
        int chioce=input.nextInt();
        if(chioce==0) {
            User user=new Admin(name);
              return user;
            }else {
                User user=new NormalUser(name);
                return user;
            }


    }
    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();
        while(true) {
            int chioce=user.menu();
            user.doOperation(chioce,bookList);
        }

    }
}
