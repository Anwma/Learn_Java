package itsource.service.impl;

import itsource.entity.User;
import itsource.dao.UserDao;
import itsource.service.UserService;
import itsource.utils.ResponseCode;
import itsource.utils.ResponseData;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return
     */
    @Override
    public ResponseData queryUserInfo(String token) {
        try {
            User user = userDao.queryUserByToken(token);
            return new ResponseData(ResponseCode.SUCCESS, user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public ResponseData userLogin(User user) {

        //1、非空校验（校验手机号、密码是否为空）
        String utell = user.getUtell();//手机号
        String upwd = user.getUpwd();//密码
        String token = null;//定义token

        if (utell == null || utell.equals("")) {
            return new ResponseData(ResponseCode.ERROR_1);
        }
        if (upwd == null || upwd.equals("")) {
            return new ResponseData(ResponseCode.ERROR_2);
        }

        //2、密码加密
        Md5Hash md5Hash = new Md5Hash(upwd, "itsource", 10);
        String newPwd = md5Hash.toString();


        try {
            //3、根据手机号utell、密码upwd查询用户信息
            User userByTellAndPwd = userDao.queryUserByTellAndPwd(utell, newPwd);
            System.out.println(utell);
            System.out.println(newPwd);

            if (userByTellAndPwd == null) {//如果查询不到数据，代表你的手机号和密码不配
                return new ResponseData(ResponseCode.ERROR_4);
            }

            if (userByTellAndPwd.getUstate() == 0) {//判断用户状态是否被冻结(禁用)
                return new ResponseData(ResponseCode.ERROR_7);
            }

            //4、生成token令牌（可根据手机号utell使用Md5Hash加密去生成一个token并转化为字符串）
            token = new Md5Hash(utell, "itsource", 10).toString();

            //5、更新token令牌(把token保存在数据表)
            userByTellAndPwd.setToken(token);
            //将token更新到数据库
            userDao.update(userByTellAndPwd);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
        //6、返回token
        return new ResponseData(ResponseCode.SUCCESS, token);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public ResponseData registerUtell(User user) {
        //1.非空校验 校验手机号、密码是否为空
        String utell = user.getUtell();//手机号
        String upwd = user.getUpwd();//密码

        if (utell == null || utell.equals("")) {
            return new ResponseData(ResponseCode.ERROR_1);
        }

        if (upwd == null || upwd.equals("")) {
            return new ResponseData(ResponseCode.ERROR_2);
        }

        try {
            //2.检验手机号是否被注册
            User userByUtell = userDao.queryUserByUtell(utell);

            //如果查询有数据，则手机号被注册
            if (userByUtell != null) {
                return new ResponseData(ResponseCode.ERROR_3);
            }

            //3.密码 加密加盐
            //Md5Hash 参数代表的意思（需要加密的参数 盐值 hashIterations 加密次数）
            Md5Hash md5Hash = new Md5Hash(upwd, "itsource", 10);
            //密码是string类型 强转
            String newPwd = md5Hash.toString();
            //新密码替换旧密码
//            System.out.println("加密后密码" + newPwd);
            user.setUpwd(newPwd);

            //4.保存用户信息
            user.setUstate(1); //设置账号状态值
            user.setUrole("普通会员");
            userDao.insert(user);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
        return new ResponseData(ResponseCode.SUCCESS);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }
}
