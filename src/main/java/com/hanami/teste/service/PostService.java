package com.hanami.teste.service;

import com.hanami.teste.dto.post.UpdatePostDTO;
import com.hanami.teste.model.Post;
import com.hanami.teste.repositories.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts() {
        return  repository.findAll();
    }

    public Post createPost(Post newPost) {
        return repository.save(newPost);
    }

    public Optional<Post> getPostById(Long id){
        if(!repository.findById(id).isPresent()){
            throw new EntityNotFoundException("Post não encontrado.");
        }
            return repository.findById(id);
    }

    public Post updatePost(Long id, UpdatePostDTO post){
        Post oldPost = getPostById(id).get();

        oldPost.setTitle(post.title());
        oldPost.setContent(post.content());

        return repository.save(oldPost);
    }

    public void deletePost(Long id){
        getPostById(id);
        repository.deleteById(id);
    }
}
