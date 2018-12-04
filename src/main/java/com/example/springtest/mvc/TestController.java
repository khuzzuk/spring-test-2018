package com.example.springtest.mvc;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("get")
    public MyBeanDTO get() {
        MyBeanDTO myBean = new MyBeanDTO();
        myBean.setMyValue("rest test");
        return myBean;
    }

    @PostMapping("post")
    public MyBeanDTO post(@RequestBody MyBeanDTO myBeanDTO) {
        return myBeanDTO;
    }
}
