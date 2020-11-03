package com.lod.forum.services;

import com.lod.forum.entities.Post;
import com.lod.forum.entities.Utilisateur;
import com.lod.forum.repositories.IPost;
import com.lod.forum.repositories.IUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private IUtilisateur utilisateurRepository;

    public Utilisateur findUtilisateurById(Long idUtilisateur) {
        return utilisateurRepository.getOne(idUtilisateur);
    }

    public Utilisateur login(String pseudo, String mdp) {
        return utilisateurRepository.findByPseudoAndMdp(pseudo, mdp);
    }
}
