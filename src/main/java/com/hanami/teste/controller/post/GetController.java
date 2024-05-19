package com.hanami.teste.controller.post;
import com.hanami.teste.dto.post.PostDTO;
import com.hanami.teste.model.Post;
import com.hanami.teste.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts/{id}")
public class GetController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity getPostById(@PathVariable Long id){
            Post post = service.getPostById(id).get();
            PostDTO result = new PostDTO(post);

            return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
