package com.harsh.jobsearch.repositories;

import com.harsh.jobsearch.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Postrepo extends MongoRepository<Post,String>{
}
