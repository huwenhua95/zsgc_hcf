package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@RestController
public class Demo1 {
    @RequestMapping("/demo")
    public  String demo1() throws Exception {
        try {
            System.out.println("demo start");
            Class.forName("com.mysql.jdbc.Driver");//加载驱动

            String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
            Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");//链接到数据库

            Statement state = conn.createStatement();   //容器
            String sql = "delete from user where id=1";

            System.out.println("删除了");

            state.executeUpdate(sql);         //将sql语句上传至数据库执行

            conn.close();//关闭通道
        } catch (Exception e) {
            System.err.println(e);
        }
        return "charu chengfong1";
    }
}

