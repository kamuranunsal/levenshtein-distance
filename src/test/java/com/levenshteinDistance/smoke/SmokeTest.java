package com.levenshteinDistance.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import com.levenshteinDistance.LevenshteinDistanceApplication;
import com.levenshteinDistance.controller.SearchController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LevenshteinDistanceApplication.class)
public class SmokeTest {

    @Autowired
    private SearchController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}