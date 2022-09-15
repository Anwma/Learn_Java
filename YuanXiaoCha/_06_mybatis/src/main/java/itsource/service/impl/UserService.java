package itsource.service.impl;

import itsource.dao.UserDao;
import itsource.entity.User;
import itsource.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Resource
    UserDao userDao;

    @Override
    public List<User> mybatis() {
        List<User> users = userDao.mybatis();
        System.out.println("业务层摸鱼负责人====" + users);
        return users;
    }
}
