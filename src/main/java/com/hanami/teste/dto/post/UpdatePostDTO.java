package com.hanami.teste.dto.post;

import com.hanami.teste.model.Post;

public record UpdatePostDTO(String title, String content) {
    public UpdatePostDTO(Post post){
        this(post.getTitle(), post.getContent());
    }
}
