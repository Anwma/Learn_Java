package demo;

import it.src.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest3 {

    /**
     * sql语句拼接
     *
     * 新增一条数据
     */
    @Test
    public void insert(){
        //1.注册驱动
        JdbcUtil jdbcUtil = new JdbcUtil();

        //sql
        String name = "勃勃";
        int age = 30;
        String sql = "INSERT INTO student(`name`,age) VALUES ('"+name+"',"+age+")";
        System.out.println(sql);

        //初始化
        Connection connection = null;
        Statement statement = null;

        try {
            //2.创建连接
            connection = jdbcUtil.getConnection();

            //3.创建sql执行对象
            statement = connection.createStatement();

            //4.执行sql
            statement.executeUpdate(sql);//编译--》运行

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            jdbcUtil.close(null,statement,connection);
        }


    }

    /**
     * 查询一条数据
     */
    @Test
    public void queryOne(){
        //1.注册驱动
        JdbcUtil jdbcUtil = new JdbcUtil();

        //模拟前端传值
        long id = 11;
        //SQL语句
        String sql = "SELECT * FROM student WHERE id = "+id;

        //初始化
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;



        try {
            //2.创建连接
            connection = jdbcUtil.getConnection();

            //3.创建sql执行对象
            statement = connection.createStatement();

            //4.执行sql
            resultSet = statement.executeQuery(sql);

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
            jdbcUtil.close(resultSet,statement,connection);
        }

    }


    /**
     * 删除
     */
    @Test
    public void delete(){
        //1.注册驱动
        JdbcUtil jdbcUtil = new JdbcUtil();

        //初始化
        Connection connection = null;
        Statement statement = null;

        try {
            //2.创建连接
            connection = jdbcUtil.getConnection();

            //3.创建sql执行对象
            statement = connection.createStatement();
            //4.执行sql
            statement.executeUpdate("DELETE FROM student WHERE id=1");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.关闭连接
            jdbcUtil.close(null,statement,connection);
        }

    }

}
