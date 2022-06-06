package com.levenshteinDistance.service;

import com.levenshteinDistance.exception.EntityNotFoundException;
import com.levenshteinDistance.model.SearchDataDTO;
import com.levenshteinDistance.model.SearchResultDTO;

public interface SearchService {

    SearchResultDTO findSimilarWords(SearchDataDTO searchData) throws EntityNotFoundException;
}
