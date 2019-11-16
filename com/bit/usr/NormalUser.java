package com.bit.usr;

import com.bit.opperation.*;

import java.util.Scanner;


/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:59
 */
public class NormalUser extends User {

    public NormalUser(String name) {
        this.name = name;
        this.operations = new Ioopperation[]{
                new Exit(),//退出
                new FindOperation(),//查找
                new BorrowOperation(),//借书
                new ReturnOperation(),//还书
                new DisplayOperation()//展示图书
        };
    }

    @Override
    public int menu() {
        System.out.println("=============================");
        System.out.println("Hello " + this.name + ", 欢迎使用图书管理系统!");
        System.out.println("1. 查找图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("4. 打印图书");
        System.out.println("0. 退出系统");
        System.out.println("=============================");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}

