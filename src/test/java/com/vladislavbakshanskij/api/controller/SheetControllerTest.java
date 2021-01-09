package com.vladislavbakshanskij.api.controller;

import com.vladislavbakshanskij.api.service.SheetType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class SheetControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexTest() throws Exception {
        this.mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("{\"isWork\":" + true + "}")));
    }

    @Test
    public void getAllTest() throws Exception {
        for (SheetType value : SheetType.values()) {
            this.mockMvc.perform(get("/all/" + value.getCode()))
                .andDo(print())
                .andExpect(status().isOk());
        }
    }

    @Test
    public void getByCountTest() throws Exception {
        for (SheetType value : SheetType.values()) {
            this.mockMvc.perform(get("/" + value.getCode() + "?count=2"))
                .andDo(print())
                .andExpect(status().isOk());
        }
    }

    @Test
    public void unknownType() throws Exception {
        this.mockMvc.perform(get("/all/someNewType").accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("this is type not supported")));
    }
}
