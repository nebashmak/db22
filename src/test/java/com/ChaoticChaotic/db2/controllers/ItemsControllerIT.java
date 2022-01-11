package com.ChaoticChaotic.db2.controllers;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class ItemsControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemsRepository repository;

    @Test
    void test() throws Exception {
        repository.save(new Items("item name", 15L));

        mockMvc.perform(get("/items")
                        .contentType(APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        throw new RuntimeException("finish this");
    }

}
