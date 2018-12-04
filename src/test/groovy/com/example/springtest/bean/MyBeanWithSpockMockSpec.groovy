package com.example.springtest.bean

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = MyBean)
class MyBeanWithSpockMockSpec extends Specification {
    @Autowired
    MyBean myBean

    @SpringBean
    MyOtherBean myOtherBean = Mock()

    def "check myBean configuration"() {
        when:
        myBean.warn()

        then:
        1 * myOtherBean.warn()
    }
}
