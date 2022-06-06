package com.levenshteinDistance.controller;

import com.levenshteinDistance.exception.EntityNotFoundException;
import com.levenshteinDistance.exception.SearchTextNotFoundException;
import com.levenshteinDistance.model.SearchDataDTO;
import com.levenshteinDistance.model.SearchResultDTO;
import com.levenshteinDistance.service.SearchService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/search")
public class SearchController {

    SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping ("/getResult")
    @CrossOrigin
    public SearchResultDTO findSimilarWords(@Valid @NotNull @RequestBody SearchDataDTO searchData) throws SearchTextNotFoundException, EntityNotFoundException {
        return searchService.findSimilarWords(searchData);
    }
}
