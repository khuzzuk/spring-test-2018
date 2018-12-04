package com.example.springtest.bean

import com.example.springtest.TestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import spock.lang.Specification

@ContextConfiguration
@TestExecutionListeners(listeners = MyTestExecutionListener, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
class BasicContextConfigurationSpec extends Specification {
    @Autowired
    MyBean myBean

    def "check context"() {
        expect:
        myBean
    }

    @TestConfiguration
    @ComponentScan("com.example.springtest.bean")
    static class BasicConfiguration {

    }
}
