package com.phase1ph.exam2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static com.phase1ph.exam2.model.Response.DEFAULT_RESPONSE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Exam2Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Exam2ApplicationIT
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "classpath:schema.sql"})
    @Test
    public void testComputeRest_Normal()
    {
        ResponseEntity<String> result = this.restTemplate.getForEntity("http://localhost:" + port + "/compute?c=5", String.class);
        assertNotNull(result);
        assertEquals("A-3\n" +
                "B-4\n" +
                "C-5\n" +
                "AVG-4.0", result.getBody());
    }

    @Test
    public void testComputeRest_Default()
    {
        ResponseEntity<String> result = this.restTemplate.getForEntity("http://localhost:" + port + "/compute?c=6", String.class);
        assertNotNull(result);
        assertEquals(DEFAULT_RESPONSE, result.getBody());
    }
}