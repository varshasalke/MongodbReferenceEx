package com.example.MongodbReferenceEx.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Set;

@Setter
@Getter
public class Post {
    @Id
    private  String id;
    private String name;

    @DBRef
    private Set<Comments> comments;
}
