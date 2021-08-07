package com.mongoex.springmongocrud.service;


import com.mongoex.springmongocrud.dto.PostDTO;
import com.mongoex.springmongocrud.entity.Post;
import com.mongoex.springmongocrud.repository.PostRepository;
import com.mongoex.springmongocrud.utils.AppUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
        @Autowired
        private PostRepository repository;

        public Flux<PostDTO> getAllPosts(){

            return repository.findAll().map(AppUtil::entityToDto);

        }

        public Mono<PostDTO> getPost(String id){

            return repository.findById(id).map(AppUtil::entityToDto);

        }

        public Mono<PostDTO> insertPost(Mono<PostDTO> postDTO){
            System.out.println("reaching service");
            return postDTO.map(AppUtil::dtoToEntity)
                    .flatMap(repository::insert)
                    .map(AppUtil::entityToDto);

        }

        public Mono<PostDTO> updatePost(Mono<PostDTO> postDTO,String id){

            return repository.findById(id)
                    .flatMap(p->postDTO.map(AppUtil::dtoToEntity))
                    .doOnNext(e->e.setId(id))
                    .flatMap(repository::save)
                    .map(AppUtil::entityToDto);
        }

        public Mono<Void> deletePost(String id){
            System.out.println("Delete Success");
            return repository.deleteById(id);
        }


}
