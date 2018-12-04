package com.example.springtest


import com.example.springtest.mvc.MyBeanDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringTestApplicationSpec extends Specification {
    @Autowired
    TestRestTemplate restTemplate
    static final url = "http://localhost:8080/test/"

    def "checkContext"() {
        given:
        def testValue = 'testValue3'
        MyBeanDTO myBeanDTO = new MyBeanDTO()
        myBeanDTO.myValue = testValue

        when:
        //def postResult = restTemplate.postForObject(url + 'post', myBeanDTO, MyBeanDTO)

        def findResult = restTemplate.getForObject(url + 'find/' + testValue, MyBeanDTO)

        then:
        with(findResult) {
            myValue == testValue
            addresses.size() == 1
        }
    }
}
