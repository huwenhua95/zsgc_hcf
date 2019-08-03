package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class Test {

    @RequestMapping("/test")
        public String test(Test user) throws Exception {
        try {
            System.out.println("test start");
            Class.forName("com.mysql.jdbc.Driver");//加载驱动

            String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
            Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");//链接到数据库

            Statement state = conn.createStatement();   //容器
          String sql = "insert into user (name,age) values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"王五");
            pstmt.setInt(2,5);
            int n = pstmt.executeUpdate();
            pstmt.close();
          // state.executeUpdate(sql);         //将sql语句上传至数据库执行

            conn.close();//关闭通道
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("执行了");
        return "charu chengfong";
    }
}



