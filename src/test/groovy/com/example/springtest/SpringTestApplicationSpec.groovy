package com.example.springtest

import com.example.springtest.bean.MyBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = SpringTestApplication)
class SpringTestApplicationSpec extends Specification {
    @Autowired
    MyBean myBean

    def "checkContext"() {
        expect:
        myBean
    }
}
