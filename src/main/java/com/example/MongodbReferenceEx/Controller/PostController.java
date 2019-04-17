package com.example.MongodbReferenceEx.Controller;

import com.example.MongodbReferenceEx.Model.Post;
import com.example.MongodbReferenceEx.Repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping(value = "/addPost")
    public String addPost(@RequestBody Post post){
        postRepo.save(post);
        return "Post added";

    }


    @PutMapping(value = "/updatePost/{id}/{name}")
    public String updatePost(@PathVariable String id, @PathVariable String name){
        Query query=new Query(Criteria.where("id").is(id));
        Update update=new Update();
        update.set("name",name);
        mongoTemplate.updateFirst(query,update,Post.class);
        return "Update";
    }

    @GetMapping(value = "/deletePost/{id}")
    public String deletePost(@PathVariable String id){
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)),Post.class);
        return "Post delete";
    }
}
