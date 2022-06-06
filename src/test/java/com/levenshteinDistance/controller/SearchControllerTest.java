package com.levenshteinDistance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.levenshteinDistance.exception.EntityNotFoundException;
import com.levenshteinDistance.model.SearchDataDTO;
import com.levenshteinDistance.model.SearchResultDTO;
import com.levenshteinDistance.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
*
* Given a basic notebook entry with the text “Word Words Wor word"
* When the frequency of the word “Word” is requested
* Then the frequency is determined to be `1`
* And the list of similar words is determined to be “Words", "Wor", "word"
*
* */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SearchController.class)
public class SearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService service;

    private SearchResultDTO createTestSearchResultDTO() {
        return SearchResultDTO.builder()
                .frequency(1)
                .similarWords(Arrays.asList("Words","Wor","word"))
                .build();
    }

    private SearchDataDTO createTestSearchDataDTO() {
        return SearchDataDTO.builder()
                .searchText("Word")
                .build();
    }

    @Test
    public void testShouldReturnSearchResultDTO() throws EntityNotFoundException {
        SearchResultDTO searchResultDTO = createTestSearchResultDTO();
        Mockito.when(service.findSimilarWords(createTestSearchDataDTO())).thenReturn(searchResultDTO);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/search/getResult")
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(createTestSearchDataDTO()))
                .contentType(MediaType.APPLICATION_JSON);

        try {
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk()).andReturn();
            System.out.print(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
