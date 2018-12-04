package com.example.springtest.bean

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericApplicationContext
import spock.lang.Specification

class MyBeanSpec extends Specification {
    def "check groovy configuration"() {
        given:
        ApplicationContext context = new GenericApplicationContext()

        new GroovyBeanDefinitionReader(context).loadBeanDefinitions('/groovyConfiguration/groovyContext.groovy')
        new XmlBeanDefinitionReader(context).loadBeanDefinitions('xmlConfiguration-context.xml')

        when:
        context.refresh()

        def groovyBean = context.getBean('myBean', MyBean)
        def xmlBean = context.getBean('myBeanFromXml', MyBean)

        then:

        with(groovyBean) {
            myValue == 'groovy value'
            myOtherBean != null
        }

        with(xmlBean) {
            myValue == 'xml value'
            myOtherBean != null
        }
    }
}
