package com.levenshteinDistance.utils;

/*Functional interface to convert string to string array*/
@FunctionalInterface
public interface IConversion {

    String[] convertStringToArray(String entry);

}
