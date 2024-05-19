package com.hanami.teste.controller.post;

import com.hanami.teste.dto.post.CreatePostDTO;
import com.hanami.teste.exception.InvalidFieldExcpection;
import com.hanami.teste.model.Post;
import com.hanami.teste.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class CreateController {
    @Autowired
    private PostService service;

    @PostMapping
    public ResponseEntity createPost(@RequestBody CreatePostDTO post){
            if (post.title().isBlank()){
                throw new InvalidFieldExcpection("Titulo");
            }

            if(post.content().isBlank()){
                throw new InvalidFieldExcpection("Conteudo");
            }

            Post newPost = new Post();
            newPost.setTitle(post.title());
            newPost.setContent(post.content());
            Post newPort = service.createPost(newPost);

            return ResponseEntity.status(HttpStatus.CREATED).body(newPort);

    }
}