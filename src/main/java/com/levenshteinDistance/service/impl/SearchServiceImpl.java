package com.levenshteinDistance.service.impl;

import com.levenshteinDistance.exception.EntityNotFoundException;
import com.levenshteinDistance.model.Entry;
import com.levenshteinDistance.model.SearchDataDTO;
import com.levenshteinDistance.model.SearchResultDTO;
import com.levenshteinDistance.repository.SearchRepository;
import com.levenshteinDistance.service.SearchService;
import com.levenshteinDistance.utils.AlgorithmUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* Service implementation class that injects repository and use methods of it
* */
@Service
public class SearchServiceImpl implements SearchService {

    SearchRepository searchRepository;

    public SearchServiceImpl(SearchRepository searchRepository){
        this.searchRepository = searchRepository;
    }
    @Override
    public SearchResultDTO findSimilarWords(SearchDataDTO searchData) throws EntityNotFoundException {
        //Given a basic notebook entry with the text “Word Words Wor word" and id: 1
        Entry entry= find(1L);
        int frequency= AlgorithmUtils.findFrequency(searchData.getSearchText(),entry.getContent());
        List<String> similarWords = AlgorithmUtils.findSimilarWords(searchData.getSearchText(),entry.getContent());
        SearchResultDTO searchResultDTO = new SearchResultDTO(frequency,similarWords);
        return searchResultDTO;
    }

    private Entry find(Long entryId) throws EntityNotFoundException {
        return searchRepository.findById(entryId).orElseThrow(() -> new EntityNotFoundException("Could not find entry with id: " + entryId));
    }

}
