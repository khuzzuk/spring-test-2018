package com.example.springtest.mvc;

import com.example.springtest.jpa.Address;
import lombok.Data;

import java.util.Set;

@Data
public class MyBeanDTO {
    private String myValue;
    private Set<Address> addresses;
}
