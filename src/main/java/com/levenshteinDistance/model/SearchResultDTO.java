package com.levenshteinDistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
* SearchResult is used to supply search result to the client
* */
public class SearchResultDTO {
    int frequency;
    List<String> similarWords;
}
