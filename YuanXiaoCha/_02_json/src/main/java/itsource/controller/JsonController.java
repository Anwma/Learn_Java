package itsource.controller;

import itsource.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JsonController {
    @RequestMapping("userTest")
    public List<User> userTest() {
        List<User> list = new ArrayList<>();

        list.add(new User("楼天城", 36));
        list.add(new User("陈立杰", 27));
        list.add(new User("吴恩达", 46));

        return list;
    }
}

