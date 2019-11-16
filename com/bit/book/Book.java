package com.bit.book;

/**
 * @author :Administrator.
 * @date :2019/11/16 0016
 * @time:11:38
 */
public class Book {
    public String name;
    public String author;
    public int price;
    public String type;//比如小说
    public boolean isBorrowed;//是否被借出

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrowed=false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ((isBorrowed==true)?"已经被借出":"没有被借出")+
                '}';
    }
}
