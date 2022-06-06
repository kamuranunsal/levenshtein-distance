package com.levenshteinDistance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find any entry.")
public class SearchTextNotFoundException extends Exception {

    public SearchTextNotFoundException(String message) {
        super(message);
    }
}