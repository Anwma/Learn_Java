package dao;

public interface IUserDao {

    /**
     * 注册（保存用户信息）
     * @param username
     * @param password
     */
    void addUser(String username,String password);

    /**
     * 登录校验用户信息
     * @return
     */
    boolean queryUserCountByUsernameAndPassword(String username,String password);

}
