package com.example.MongodbReferenceEx.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Comments {

    @Id
    private String id;
    private String description;
}
