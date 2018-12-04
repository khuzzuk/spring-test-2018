package com.example.springtest.bean

import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = MyBean)
class MyBeanWithMockSpec extends Specification {
    @Autowired
    MyBean myBean

    @MockBean
    MyOtherBean myOtherBean

    def "check myBean configuration"() {
        when:
        myBean.warn()

        then:
        Mockito.verify(myOtherBean).warn()
    }
}
