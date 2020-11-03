package com.lod.forum.repositories;

import com.lod.forum.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUtilisateur extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByPseudoAndMdp(String pseudo, String mdp);

    List<Utilisateur> findAll();
}
