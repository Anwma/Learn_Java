package dao.impl;

import dao.IUserDao;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements IUserDao{

    /**
     * 注册（保存用户信息）
     * @param username
     * @param password
     */
    @Override
    public void addUser(String username, String password) {

        //初始化
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //sql语句
        String sql = "INSERT INTO t_user(username,password) VALUES (?,?);";

        //1.加载驱动
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            //2.创建连接
            connection = jdbcUtil.getConnection();

            //3.创建sql执行对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            //4.执行sql
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            jdbcUtil.close(null,preparedStatement,connection);
        }

    }

    /**
     * 登录校验用户信息
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean queryUserCountByUsernameAndPassword(String username, String password) {

        //初始化
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //sql
        String sql = "SELECT COUNT(*) 'count' FROM t_user WHERE username = ? AND `password` = ?";

        //1.加载驱动
        JdbcUtil jdbcUtil = new JdbcUtil();


        try {
            //2.创建连接
            connection = jdbcUtil.getConnection();

            //3.创建sql执行对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            //4.执行sql
            resultSet = preparedStatement.executeQuery();

            //遍历数据
            while (resultSet.next()){
                int count = resultSet.getInt("count");
                System.out.println("count= "+count);

                //判断count是否大于1,如果是,返回true
                if (count>0){
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            jdbcUtil.close(resultSet,preparedStatement,connection);
        }
        return false;
    }
}
