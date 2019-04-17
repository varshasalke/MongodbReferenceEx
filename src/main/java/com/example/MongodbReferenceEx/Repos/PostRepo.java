package com.example.MongodbReferenceEx.Repos;

import com.example.MongodbReferenceEx.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String> {
}
