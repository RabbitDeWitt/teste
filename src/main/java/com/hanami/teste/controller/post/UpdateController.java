package com.hanami.teste.controller.post;

import com.hanami.teste.dto.post.UpdatePostDTO;

import com.hanami.teste.exception.InvalidFieldExcpection;
import com.hanami.teste.model.Post;
import com.hanami.teste.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/{id}")
public class UpdateController {
    @Autowired
    private PostService service;

    @PutMapping
    public String updatePost(@PathVariable Long id, @RequestBody UpdatePostDTO post){
        if(post.title().isBlank()){
            throw new InvalidFieldExcpection("Titulo");
        }

        if(post.content().isBlank()){
            throw new InvalidFieldExcpection("Conteudo");
        }

        Post updatedPost = service.updatePost(id, post);

        return "Post atualizado com sucesso!!!";
    }
}
