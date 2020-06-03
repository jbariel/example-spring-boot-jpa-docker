package com.jbariel.example.jpaswapping.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class GenericCrudTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testCrud() throws Exception {
        Assert.isTrue(true, "Just checking!");
        mvc.perform(get("/coal-mine/canary")).andDo(print()).andExpect(status().isOk());
    }

}