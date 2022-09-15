package itsource.controller;

import itsource.entity.User;
import itsource.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    IUserService iUserService;

    @RequestMapping("mybatis")
    public List<User> mybatis() {
        List<User> users = iUserService.mybatis();
        System.out.println("控制层拍了拍你说：兄弟,摸鱼这种好事你不喊我？" + users);
        return users;
    }
}
