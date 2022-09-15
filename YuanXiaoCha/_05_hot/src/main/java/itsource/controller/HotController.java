package itsource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotController {
    @RequestMapping("hot")
    public String hot(){
        System.out.println("热部署说摸鱼贴贴!"); //本地控制台打印
        return "小猫咪说你拿着我的🐟摸干嘛(。・`ω´・)";
    }
}
