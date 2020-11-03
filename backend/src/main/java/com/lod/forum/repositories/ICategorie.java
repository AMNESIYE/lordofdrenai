package com.lod.forum.repositories;

import com.lod.forum.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategorie extends JpaRepository<Categorie, Long> {

    List<Categorie> findByAssociation(Long association);
}
