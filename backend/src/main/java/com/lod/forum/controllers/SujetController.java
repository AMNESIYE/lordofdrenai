package com.lod.forum.controllers;

import com.lod.forum.entities.Categorie;
import com.lod.forum.entities.Post;
import com.lod.forum.entities.Sujet;
import com.lod.forum.repositories.ICategorie;
import com.lod.forum.repositories.ISujet;
import com.lod.forum.services.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sujets")
public class SujetController {

    @Autowired
    private SujetService sujetService;

    @GetMapping("/all/{idCategorie}")
    public ResponseEntity findSujetsByCategorie(@PathVariable(name = "idCategorie") Long idCategorie) {
        if (idCategorie == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve categorie with null ID");
        }
        List<Sujet> sujets = sujetService.findSujetsByCategorie(idCategorie);
        if (sujets == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sujets);
    }

    @GetMapping("/{idSujet}")
    public ResponseEntity findBySujets(@PathVariable(name = "idSujet") Long idSujet) {
        if (idSujet == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve sujet with null ID");
        }
        Sujet sujet = sujetService.findBySujet(idSujet);
        if (sujet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sujet);
    }

    @GetMapping("/all")
    public ResponseEntity findAllSujets() {
        List<Sujet> sujetList = sujetService.findAllSujets();
        if (sujetList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sujetList);
    }
}
