package com.example.MongodbReferenceEx.Controller;

import com.example.MongodbReferenceEx.Model.Comments;
import com.example.MongodbReferenceEx.Repos.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {
    @Autowired
    private CommentsRepo commentsRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping(value = "/addComments")
    public String addComments(@RequestBody Comments comments){
        commentsRepo.save(comments);
        return "Comments added";

    }

    @GetMapping(value = "/delete/{id}")
    public String deleteComments(@PathVariable String id){
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)),Comments.class);
        return "delete";
    }

}
