package com.example.seleniumtest

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.context.support.GenericApplicationContext
import org.springframework.core.Ordered
import org.springframework.test.context.TestContext
import org.springframework.test.context.TestExecutionListener

class SeleniumExecution implements TestExecutionListener, Ordered {

    SeleniumExecution() {
        WebDriverManager.chromedriver().setup()
    }

    @Override
    void beforeTestClass(TestContext testContext) throws Exception {
        GenericApplicationContext context = testContext.getApplicationContext() as GenericApplicationContext
        context.registerBean(ChromeDriver)
    }

    @Override
    void beforeTestMethod(TestContext testContext) throws Exception {
        def value = testContext.getTestClass().getDeclaredAnnotation(SeleniumTest).value()
        testContext.getApplicationContext().getBean(ChromeDriver).get(value)
    }

    @Override
    void afterTestClass(TestContext testContext) throws Exception {
        testContext.applicationContext.getBean(ChromeDriver).quit()
    }

    @Override
    final int getOrder() {
        return 1999
    }
}
