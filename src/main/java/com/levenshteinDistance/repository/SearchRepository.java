package com.levenshteinDistance.repository;

import com.levenshteinDistance.model.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends CrudRepository<Entry,Long> {
}
