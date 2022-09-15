package itsource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping("web")
    public String web(){
        System.out.println("那怎么可能不摸？"); //本地控制台打印
        return "web拍了拍你说还摸鱼不？";//
    }
}
