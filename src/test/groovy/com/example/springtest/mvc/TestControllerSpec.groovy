package com.example.springtest.mvc

import com.example.springtest.SpringTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.env.Environment
import org.springframework.test.annotation.DirtiesContext
import spock.lang.Specification
import spock.lang.Stepwise

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringTest
@Stepwise
class TestControllerSpec extends Specification {
    @LocalServerPort
    int port

    @Autowired
    Environment environment

    @Value('${test.controller.address}')
    String value

    @Autowired
    TestRestTemplate restTemplate

    @DirtiesContext
    def "test get my bean"() {
        given:
        String url = value + port + "/test/get"

        when:
        def myBean = restTemplate.getForObject(url, MyBeanDTO)

        then:
        with(myBean) {
            myValue == 'rest test'
        }
    }

    def "test post my bean"() {
        given:
        String url = this.value + port + "/test/post"
        MyBeanDTO myBeanDTO = new MyBeanDTO()
        def value = 'test post value'
        myBeanDTO.myValue = value

        when:
        def myBean = restTemplate.postForObject(url, myBeanDTO, MyBeanDTO)

        then:
        with(myBean) {
            myValue == value
        }
    }
}
