package com.harsh.jobsearch.Controller;

import com.harsh.jobsearch.repositories.Postrepo;
import com.harsh.jobsearch.model.Post;
import com.harsh.jobsearch.repositories.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    Postrepo repo;

    @Autowired
    SearchRepo srepo;

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return repo.findAll();
    }
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
    @GetMapping("/posts/{text}")
    public List<Post> GetPostbyText(@PathVariable String text){
        return srepo.findByText(text);
    }

}
