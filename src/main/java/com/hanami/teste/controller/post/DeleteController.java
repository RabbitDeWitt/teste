package com.hanami.teste.controller.post;

import com.hanami.teste.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts/{id}")
public class DeleteController {

    @Autowired
    private PostService service;

    @DeleteMapping
    public String deletePostById(@PathVariable Long id){
    service.deletePost(id);
    return "Post deletado com sucesso!!!";
    }
}
