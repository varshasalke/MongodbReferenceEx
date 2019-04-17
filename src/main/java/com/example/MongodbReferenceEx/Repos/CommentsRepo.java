package com.example.MongodbReferenceEx.Repos;

import com.example.MongodbReferenceEx.Model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentsRepo extends MongoRepository<Comments,String> {
}
