package com.hanami.teste.repositories;

import com.hanami.teste.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {
}
