package com.example.springtest.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyOtherBean {
    public void warn() {
        log.warn("Warn from MyOtherBean");
    }

}
