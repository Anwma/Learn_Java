package demo;

import it.src.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest1 {


    /**
     * 查询全部数据
     */
    @Test
    public void queryAll() {
        //初始化
        long id = 0;
        String name = null;
        int age = 0;

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建连接
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "anwma");
            //3.创建sql执行对象
            Statement statement = connection.createStatement();
            //4.执行sql
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            //拿出数据并打印
            List<Student> list = new ArrayList<>();//集合

            while (resultSet.next()) {
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                age = resultSet.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
//                System.out.println("id= "+id+" "+"name= "+name+" "+"age= "+age);

                list.add(student);
            }

//            System.out.println(list);
//            for (Student student : list) {
//                System.out.println(student);
//            }
            list.forEach(e -> System.out.println(e));

            //5.关闭连接
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单条查询
     */
    @Test
    public void queryByOne() {

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建连接
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "anwma");
            //3.创建sql执行对象
            Statement statement = connection.createStatement();
            //4.执行sql
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE id=1");
//            System.out.println("resultSet="+resultSet);
            //拿出数据并打印
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("id= " + id + " " + "name= " + name + " " + "age= " + age);
            }

            //5.关闭连接
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 单条数据删除
     */
    @Test
    public void delete() {

        //初始化
        Connection connection = null;
        Statement statement = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "anwma");
            //3.创建sql执行对象
            statement = connection.createStatement();
            //4.执行sql
            statement.executeUpdate("DELETE FROM student WHERE id=4");
            //5.关闭连接
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增一条数据
     */
    @Test
    public void insert() {

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建连接
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "anwma");
            //3.创建sql执行对象
            Statement statement = connection.createStatement();
            //4.执行sql
            statement.executeUpdate("INSERT INTO student(`name`,age) VALUES ('吴恩达',48)");
            //5.关闭连接
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
