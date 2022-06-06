package com.levenshteinDistance.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import com.levenshteinDistance.LevenshteinDistanceApplication;
import com.levenshteinDistance.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LevenshteinDistanceApplication.class)
public class HTTPRequestTest {

    @LocalServerPort
    private int localPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testShouldReturnMessage() {
        assertThat(testRestTemplate.getForObject(TestConfig.BASE_URL + localPort + TestConfig.USERS_ENDPOINT, String.class)
                .contains("[]"));
    }
}