package util;

import java.sql.*;

/**
 * JDBC工具类
 */
public class JdbcUtil {

    //静态块：类加载的时候就会执行，只会执行一次
    static {//静态块
        try {
            //1.注册驱动(只需要注册一次)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2.获取连接(每次都要获取)  封装获取连接的方法
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root",
                "123456"
        );
    }

    //3.关闭连接(每次都要关闭)
    public void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
