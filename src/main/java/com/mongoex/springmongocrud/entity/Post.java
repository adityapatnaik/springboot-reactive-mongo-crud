package com.mongoex.springmongocrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "post")
public class Post {
    @Id
    private String id;
    private String link;
    private String desc;
    private String likes;

}
