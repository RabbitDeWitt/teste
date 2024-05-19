package com.hanami.teste.dto.post;

import com.hanami.teste.model.Post;

public record PostDTO(Long id, String title, String content) {
    public PostDTO(Post post){
        this(post.getId(), post.getTitle(), post.getContent());
    }
}
