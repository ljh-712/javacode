///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package control;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// *
// * @author Administrator
// */
//public class SqlLink{
//
//    public static void main(String[] args)
//    {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("加载驱动成功");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("加载驱动失败");
//        }
//        Connection conn = null;
//        try {
//            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/person?userUnicode=true&characterEncoding=UTF8&useSSL=false","root" ,"");
//            System.out.println("连接成功");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("连接失败");
//        }
//
//    }
//}
//
//
//
//
