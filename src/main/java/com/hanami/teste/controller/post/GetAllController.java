package com.hanami.teste.controller.post;

import com.hanami.teste.model.Post;
import com.hanami.teste.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class GetAllController {
    @Autowired
    private PostService service;

    @GetMapping
    public List<Post> getAllPosts(){
        return service.getAllPosts();
    }
}
