package com.bit.usr;

import com.bit.opperation.*;

import java.util.Scanner;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:59
 */

public class Admin extends User{
    public Admin(String name) {
        this.name = name;
        this.operations= new Ioopperation[]{
                new Exit(),//0
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation(),





        };
    }

    @Override
    public int menu() {
        System.out.println("=============================");
        System.out.println("Hello " + this.name + ", 欢迎使用图书管理系统!");
        System.out.println("1. 查找图书");
        System.out.println("2. 新增图书");
        System.out.println("3. 删除图书");
        System.out.println("4. 显示所有图书");
        System.out.println("0. 退出系统");
        System.out.println("=============================");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}

