package com.mongoex.springmongocrud.controller;

import com.mongoex.springmongocrud.dto.PostDTO;
import com.mongoex.springmongocrud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService service;

    //get all Posts
    @GetMapping
    public Flux<PostDTO> getAllPosts(){

        return service.getAllPosts();
    }

    //get one Post
    @GetMapping("/{id}")
    public Mono<PostDTO> getPosts(@PathVariable String id){

        return service.getPost(id);

    }
    //insert one Post
    @PostMapping
    public Mono<PostDTO> insertPost(@RequestBody Mono<PostDTO> postDTOMono){
        System.out.println("reaching controller");
        return service.insertPost(postDTOMono);

    }
    //update one Post
    @PutMapping("/update/{id}")
    public Mono<PostDTO> updatePost(@RequestBody Mono<PostDTO> postDTOMono , @PathVariable String id){
        return service.updatePost(postDTOMono,id);
    }

    //delete one Post
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deletePost(@PathVariable String id){

        return service.deletePost(id);

    }
}
