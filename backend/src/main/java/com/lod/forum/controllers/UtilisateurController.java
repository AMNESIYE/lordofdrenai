package com.lod.forum.controllers;

import com.lod.forum.entities.Utilisateur;
import com.lod.forum.repositories.IUtilisateur;
import com.lod.forum.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/{idUtilisateur}")
    public ResponseEntity findUtilisateurById(@PathVariable(name = "idUtilisateur") Long idUtilisateur) {
        if (idUtilisateur == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve user with null ID");
        }
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(idUtilisateur);
        if (utilisateur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(utilisateur);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam(name = "pseudo") String pseudo, @RequestParam(name = "mdp") String mdp) {
        if (StringUtils.isEmpty(pseudo) || StringUtils.isEmpty(mdp)) {
            return ResponseEntity.badRequest().body("Cannot login with empty username or password");
        }
        Utilisateur authenticatedUser = utilisateurService.login(pseudo, mdp);
        if (authenticatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authenticatedUser);
    }
}
