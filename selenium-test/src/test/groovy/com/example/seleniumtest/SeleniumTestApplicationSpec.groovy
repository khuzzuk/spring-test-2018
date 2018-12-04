package com.example.seleniumtest


import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestExecutionListeners
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestExecutionListeners(listeners = SeleniumExecution, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
@SeleniumTest("http://localhost:8080/home")
class SeleniumTestApplicationSpec extends Specification {
    @Autowired
    WebDriver driver

    def "check home page"() {
        when:
        def homePage = PageFactory.initElements(driver, HomePage)

        then:
        homePage.label
    }
}
