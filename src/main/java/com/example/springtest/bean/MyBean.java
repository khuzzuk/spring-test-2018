package com.example.springtest.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MyBean {
    private final MyOtherBean myOtherBean;

    private String myValue;
}
