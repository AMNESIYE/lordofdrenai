package com.lod.forum.services;

import com.lod.forum.entities.Post;
import com.lod.forum.entities.Utilisateur;
import com.lod.forum.repositories.IPost;
import com.lod.forum.repositories.IUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private IPost postRepository;
    @Autowired
    private IUtilisateur utilisateurRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> findBySujets(Long idSujet) {
        return postRepository.findByIdSujet(idSujet);
    }

    public List<Utilisateur> findUtilisateurForPost(Long idSujet){
        List<Post> listPosts = postRepository.findByIdSujet(idSujet);
        List<Utilisateur> listUtilisateur = utilisateurRepository.findAll();
        List<Utilisateur> listUtilisateurInPost = new ArrayList<>();
        for (Post post:
             listPosts) {
            for (Utilisateur utilisateur:
                 listUtilisateur) {
                if(post.getIdUtilisateur() == utilisateur.getId()) {
                    listUtilisateurInPost.add(utilisateur);
                }
            }
        }
        return listUtilisateurInPost;
    }
}
