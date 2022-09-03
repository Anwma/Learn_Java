package demo;

import it.src.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest2 {



    /**
     * 全查询
     */
    @Test
    public void queryAll(){

        //初始化
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.创建驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "anwma"
            );
            //3.创建sql执行对象
            statement = connection.createStatement();
            //4.执行sql
            resultSet = statement.executeQuery("SELECT * FROM student");
            //拿出数据并打印
            List<Student> list = new ArrayList<>();//创建集合

            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                list.add(student);
//                System.out.println("id= "+id+" "+"name= "+name+" "+"age= "+age);
            }
//            System.out.println(list);
            //遍历出数据
//            for (Student student : list) {
//                System.out.println(student);
//            }
            list.forEach(e->System.out.println(e));


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.关闭连接
            try {
                //关闭resultSet
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    //关闭statement
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        //关闭connection
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }



        }

    }

    /**
     * 单条查询
     */
    @Test
    public void queryOne(){
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                    "root",
                    "anwma"
            );
            //3.创建sql对象
            Statement statement = connection.createStatement();
            //4.执行sql
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE id =2 OR 1=1");
            //打印sql
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("id= "+id+" "+"name= "+name+" "+"age= "+age);
            }

            //5.关闭连接
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
