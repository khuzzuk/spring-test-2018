package com.example.springtest.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

import javax.persistence.EntityManager

@DataJpaTest
class TestEntityRepoSpec extends Specification {
    @Autowired
    TestEntityRepo testEntityRepo

    @Autowired
    EntityManager entityManager

    def "test save entity"() {
        given:
        TestEntity testEntity = new TestEntity()
        def name = 'test name'
        testEntity.name = name

        when:
        testEntityRepo.save(testEntity)

        entityManager.flush()

        def entities = testEntityRepo.findAll()

        then:
        with(entities) {
            size() == 1
        }
    }
}
