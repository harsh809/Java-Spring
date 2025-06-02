package com.harsh.jobsearch.repositories;

import com.harsh.jobsearch.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String text);
}
