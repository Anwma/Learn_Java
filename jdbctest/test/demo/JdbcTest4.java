package demo;

import it.src.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest4 {

    /**
     * 查询一条数据
     */
    @Test
    public void queryOne(){
        //1.注册驱动
        JdbcUtil jdbcUtil = new JdbcUtil();

        //模拟前端传值
//        long id = 11;
        //SQL语句
//        String sql = "SELECT * FROM student WHERE id = "+id+" OR 1=1";
        String sql = "SELECT * FROM student WHERE id = ? AND `name` = ?";
//        System.out.println(sql);

        //初始化
        Connection connection = null;
//        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //2.创建连接
            connection = jdbcUtil.getConnection();

            //3.创建sql执行对象      预编译
            preparedStatement = connection.prepareStatement(sql);

            //设置？的值
            preparedStatement.setLong(1,14);
            preparedStatement.setString(2,"张艺兴");

            //4.执行sql
            resultSet = preparedStatement.executeQuery();

            //打印数据
            while (resultSet.next()){
                long id1 = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("id1= "+id1+" "+"name= "+name+" "+"age= "+age);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.关闭连接
            jdbcUtil.close(resultSet,preparedStatement,connection);
        }

    }
}
