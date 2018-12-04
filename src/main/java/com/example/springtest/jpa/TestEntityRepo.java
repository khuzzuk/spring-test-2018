package com.example.springtest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TestEntityRepo extends JpaRepository<TestEntity, Long> {
    TestEntity findByName(String name);
}
