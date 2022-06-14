package com.example.loonaverse.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class SongResourceIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Container
    private static MySQLContainer<?> mySQLdb = new MySQLContainer<>("mysql:5.7")
            .withDatabaseName("Loonaverse")
            .withUsername("Loonaverse")
            .withPassword("Loonaverse")
            .withCommand("mysqld", "--lower_case_table_names=1", "--skip-ssl", "--character_set_server=utf8mb4", "--explicit_defaults_for_timestamp")
            .withExposedPorts(3306)
            .waitingFor(Wait.forListeningPort());

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () ->
                String.format("jdbc:mysql://%s:%s/Loonaverse?useSSL=false&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true", mySQLdb.getHost(), mySQLdb.getFirstMappedPort()));
    }

    @Test
    void getAllSongs() throws Exception {
        mockMvc.perform(
                        get("/songs")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(12));
    }
}
