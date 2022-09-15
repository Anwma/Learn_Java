package itsource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YamlController {
    @RequestMapping("yaml")
    public String yaml(){
        System.out.println("端口号对不对啊,你还摸鱼-_-!"); //本地控制台打印
        return "yaml说你的基本语法学完了?你摸啥子鱼！";
    }
}
