package com.lod.forum.repositories;

import com.lod.forum.entities.Post;
import com.lod.forum.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPost extends JpaRepository<Post, Long> {

    List<Post> findByIdSujet(Long idSujet);
}
