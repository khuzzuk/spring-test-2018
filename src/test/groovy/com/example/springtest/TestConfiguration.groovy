package com.example.springtest

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.AliasFor

import java.lang.annotation.ElementType
import java.lang.annotation.Inherited
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE])
@Inherited
@Configuration
@interface TestConfiguration {
    @AliasFor(annotation = Configuration)
    String value() default ""
}
