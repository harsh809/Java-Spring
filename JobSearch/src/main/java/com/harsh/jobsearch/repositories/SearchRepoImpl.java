package com.harsh.jobsearch.repositories;

import com.harsh.jobsearch.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo{
    @Autowired
    private MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        List<Post> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("JobData");
        MongoCollection<Document> collection = database.getCollection("JobPosts");

        List<Document> pipeline = Arrays.asList(
                            new Document("$search",
                            new Document("text", new Document("query", text)
                                    .append("path", Arrays.asList("desc", "techs", "profile")))),
                            new Document("$sort",
                            new Document("exp", 1L)),
                            new Document("$limit", 5L));

        AggregateIterable<Document> result = collection.aggregate(pipeline);

        result.forEach(doc->posts.add(converter.read(Post.class,doc)));

        return posts;
    }
}
