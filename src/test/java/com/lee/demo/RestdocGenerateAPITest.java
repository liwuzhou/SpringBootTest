package com.lee.demo;

import com.lee.demo.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 使用restdoc生成api文档测试类
 */

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
//该注解开启了生成snippets文件，并指定了文件生成路径
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class RestdocGenerateAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void restdocAPITest() throws Exception{

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(containsString("update salary success")))
                .andDo(document("home"));
    }


}
