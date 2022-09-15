package itsource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("test")
    public String test(){
        System.out.println("摸鱼！"); //本地控制台打印
        return "就是你小子摸鱼是吧？";//
    }
}
