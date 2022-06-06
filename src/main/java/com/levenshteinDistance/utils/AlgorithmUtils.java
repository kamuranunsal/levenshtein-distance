package com.levenshteinDistance.utils;

import java.util.*;
import java.util.function.Function;

/*
* Algorithm util class that provides static method to calculate some result and generate data
* */
public class AlgorithmUtils {

    //
    public static int findFrequency(String searchText, String entryText) {

        IConversion converter = AlgorithmUtils::convertStringToArray;

        String[] words = converter.convertStringToArray(entryText);

        int frequency = 0;
        // Loop to iterate over the words
        for(int i=0;i<words.length;i++)
        {
            if(searchText.equals(words[i])){
                frequency ++;
            }
        }
        return frequency;
    }

    // Splitting to find the word
    private static String[] convertStringToArray(String entryText){
        Function<String,String[]> splitFunction = text->text.split(" ");
        return splitFunction.apply(entryText);
    }

    public static List<String> findSimilarWords(String searchText, String entryText) {
        List<String> similarWords = new ArrayList<>();
        IConversion converter = AlgorithmUtils::convertStringToArray;

        String[] words = converter.convertStringToArray(entryText);

        for(int i=0;i<words.length;i++)
        {
            if(calculateLevenshteinDistance(searchText,words[i])==1){
                similarWords.add(words[i]);
            }
        }
        return similarWords;
    }

    private static int calculateLevenshteinDistance(String searchText, String entryText) {
        int searchTextSize = searchText.length() + 1;
        int entryTextSize = entryText.length() + 1;
        int[][] distance = new int[searchTextSize][];
        for (int i = 0; i < searchTextSize; ++i) {
            distance[i] = new int[entryTextSize];
        }
        for (int i = 0; i < searchTextSize; ++i) {
            distance[i][0] = i;
        }
        for (int j = 0; j < entryTextSize; ++j) {
            distance[0][j] = j;
        }
        for (int i = 1; i < searchTextSize; ++i) {
            for (int j = 1; j <  entryTextSize; ++j) {
                char searchChar = searchText.charAt(i - 1);
                char entryChar = entryText.charAt(j - 1);
                distance[i][j] = findMin(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + (Objects.equals(searchChar, entryChar) ? 0 : 1) // + substitution cost
                );
            }
        }
        return distance[searchText.length()][entryText.length()];
    }

    private static int findMin(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}
