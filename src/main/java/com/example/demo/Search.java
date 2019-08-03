package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;*/
import java.sql.*;
    @RestController
    public class Search {
        @RequestMapping("/select")
        public String search() throws Exception {
            try {
                System.out.println("select start");
                Class.forName("com.mysql.jdbc.Driver");//加载驱动
                String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
                // 获取连接
                Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");
                Statement state = conn.createStatement();   //容器
                String sql = "select * from user ";
                System.out.println("查看了");
                ResultSet rs = state.executeQuery(sql);
                //将sql语句上传至数据库执行
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString(3);// 根据列索引取得列的值,列索引从2开始
                    String age = rs.getString("age");
                    System.out.println(id);
                    System.out.println(name);
                    System.out.println(age);

                }
                rs.close();
                state.close();
                conn.close();//关闭通道
            } catch (Exception e) {
                System.err.println(e);
            }
            return "search ";
        }
    }
