package com.example.springtest.bean

import org.springframework.context.support.GenericApplicationContext
import org.springframework.test.context.TestContext
import org.springframework.test.context.TestExecutionListener

class MyTestExecutionListener implements TestExecutionListener {
    @Override
    void beforeTestClass(TestContext testContext) throws Exception {
        GenericApplicationContext context = testContext.applicationContext as GenericApplicationContext
        context.registerBean(MyBean)
    }
}
