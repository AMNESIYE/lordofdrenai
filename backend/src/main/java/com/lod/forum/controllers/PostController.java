package com.lod.forum.controllers;

import com.lod.forum.entities.Post;
import com.lod.forum.entities.Sujet;
import com.lod.forum.entities.Utilisateur;
import com.lod.forum.repositories.ICategorie;
import com.lod.forum.repositories.IPost;
import com.lod.forum.repositories.ISujet;
import com.lod.forum.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public ResponseEntity findAllPosts() {
        List<Post> postList = postService.findAllPosts();
        if (postList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(postList);
    }

    @GetMapping("/{idSujet}")
    public ResponseEntity findBySujets(@PathVariable(name = "idSujet") Long idSujet) {
        List<Post> postList = postService.findBySujets(idSujet);
        if (postList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(postList);
    }

    @GetMapping("/checkUsers/{idSujet}")
    public ResponseEntity findByUtilisateurByPostsInSujets(@PathVariable(name = "idSujet") Long idSujet) {
        List<Utilisateur> utilisateurList = postService.findUtilisateurForPost(idSujet);
        if (utilisateurList == null) {
            return ResponseEntity.notFound().build(); 
        }
        return ResponseEntity.ok().body(utilisateurList);
    }
}
