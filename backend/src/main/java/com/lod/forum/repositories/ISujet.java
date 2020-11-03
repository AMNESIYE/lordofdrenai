package com.lod.forum.repositories;

import com.lod.forum.entities.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISujet extends JpaRepository<Sujet, Long> {

    List<Sujet> findByIdCategorie(Long idCategorie);
}
