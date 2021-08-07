package com.mongoex.springmongocrud.utils;

import com.mongoex.springmongocrud.dto.PostDTO;
import com.mongoex.springmongocrud.entity.Post;
import org.springframework.beans.BeanUtils;


public class AppUtil {

    public static Post dtoToEntity(PostDTO postDTO){
        Post post = new Post();
        BeanUtils.copyProperties(postDTO,post);
        return post;
    }

    public static PostDTO entityToDto(Post post){
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post,postDTO);
        return postDTO;
    }
}
