package it.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo {

    /**
     * 单条数据删除
     * @param args
     */
    public static void main(String[] args){

        try {
            //1.注册驱动    try-catch- 捕捉异常  Mysql5
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Mysql8    com.mysql.cj.jdbc.Driver

            //2.创建连接
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "anwma");
            //3.创建sql执行对象
            Statement statement = connection.createStatement();
            //4.执行sql
            statement.executeUpdate("DELETE FROM student WHERE id = 4");
            //5.关闭连接(先开后关，后开先关)
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
