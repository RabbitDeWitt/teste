package com.hanami.teste.dto.post;

import com.hanami.teste.model.Post;

public record CreatePostDTO(String title, String content) {
    public CreatePostDTO(Post post){
        this(post.getTitle(), post.getContent());
    }
}
