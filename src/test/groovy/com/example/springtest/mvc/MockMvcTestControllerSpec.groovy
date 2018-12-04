package com.example.springtest.mvc

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class MockMvcTestControllerSpec extends Specification {
    @Shared
    MockMvc mockMvc

    def setupSpec() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build()
    }

    def "test mvc configuration"() {
        when:
        def response = mockMvc.perform(get("/test/get")).andReturn().response

        then:
        response.status == 200
    }

    def "test post"() {
        given:
        ObjectMapper objectMapper = new ObjectMapper()

        MyBeanDTO myBeanDTO = new MyBeanDTO()
        def beanValue = 'post value'
        myBeanDTO.myValue = beanValue
        def dtoValue = objectMapper.writeValueAsString(myBeanDTO)

        when:
        def builder = post("/test/post")
                .content(dtoValue)
                .contentType(MediaType.APPLICATION_JSON_UTF8)

        def response = mockMvc.perform(builder).andReturn().response
        def value = objectMapper.readValue(response.getContentAsString(), MyBeanDTO)
        then:
        with(value) {
            myValue == 'post value'
        }
    }
}
