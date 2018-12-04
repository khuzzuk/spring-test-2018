package com.example.springtest.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class MyBean {
    private final MyOtherBean myOtherBean;

    private String myValue;

    public void warn() {
        log.warn("Warn from MyBean");
        myOtherBean.warn();
    }
}
