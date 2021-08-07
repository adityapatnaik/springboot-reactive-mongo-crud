package com.mongoex.springmongocrud.repository;

import com.mongoex.springmongocrud.entity.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveMongoRepository<Post, String> {

}
