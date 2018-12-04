package com.example.springtest.bean

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.ContextHierarchy
import spock.lang.Specification

@ContextHierarchy([
        @ContextConfiguration(classes = MyOtherBean),
        @ContextConfiguration(classes = MyBean),
])
class ConfigurationWithHierarchySpec extends Specification {
    @Autowired
    MyBean myBean

    def "check hierarchy"() {
        expect:
        myBean
    }
}
