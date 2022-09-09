package service;

public interface IUserService {

    /**
     * 注册（保存用户信息）
     * @param username
     * @param password
     */
    void addUser(String username,String password);

    /**
     * 登录校验用户信息
     * @param username
     * @param password
     */
    boolean checkUsernameAndPassword(String username,String password);
}
