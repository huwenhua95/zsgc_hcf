package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
@RestController
public class Demo {
    @RequestMapping("/demo1")
    public  String demo() throws Exception {
        try {
            System.out.println("demo start");
            Class.forName("com.mysql.jdbc.Driver");//加载驱动

            String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
            Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");//链接到数据库

            Statement state = conn.createStatement();   //容器
             String sql = "update user set name=? where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "李四");
            pstmt.setInt(2, 5);
            int i = pstmt.executeUpdate();
            System.out.println("修改了");

           // state.executeUpdate(sql);//将sql语句上传至数据库执行
            pstmt.close();
            conn.close();//关闭通道
        } catch (Exception e) {
            System.err.println(e);
        }
        return "charu chengfong2";
    }
}






