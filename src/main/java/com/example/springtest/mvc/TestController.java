package com.example.springtest.mvc;

import com.example.springtest.jpa.Address;
import com.example.springtest.jpa.AddressRepo;
import com.example.springtest.jpa.TestEntity;
import com.example.springtest.jpa.TestEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestEntityRepo testEntityRepo;
    @Autowired
    private AddressRepo addressRepo;

    private List<TestEntity> testEntities;

    @PostConstruct
    private void init() {
        testEntities = testEntityRepo.findAll();
    }

    @GetMapping("get")
    public MyBeanDTO get() {
        MyBeanDTO myBean = new MyBeanDTO();
        myBean.setMyValue("rest test");
        return myBean;
    }

    @PostMapping("post")
    public MyBeanDTO post(@RequestBody MyBeanDTO myBeanDTO) {
        Address address = addressRepo.save(create("city"));
        TestEntity testEntity = new TestEntity();
        testEntity.setName(myBeanDTO.getMyValue());
        testEntity.setAddresses(Set.of(address));
        testEntityRepo.save(testEntity);
        return myBeanDTO;
    }

    @GetMapping("find/{name}")
    public MyBeanDTO find(@PathVariable(name = "name") String name) {
        TestEntity testEntity = testEntityRepo.findByName(name);
        MyBeanDTO myBeanDTO = new MyBeanDTO();
        myBeanDTO.setMyValue(testEntity.getName());
        myBeanDTO.setAddresses(testEntity.getAddresses());
        return myBeanDTO;
    }

    private Address create(String city) {
        Address address = new Address();
        address.setCity(city);
        return address;
    }

    @Scheduled(fixedDelay = 1000)
    private void doSomething() {
        System.out.println("scheduled");
    }
}
