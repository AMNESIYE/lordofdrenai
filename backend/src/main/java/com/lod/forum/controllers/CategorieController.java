package com.lod.forum.controllers;

import com.lod.forum.entities.Categorie;
import com.lod.forum.repositories.ICategorie;
import com.lod.forum.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/{idCategorie}")
    public ResponseEntity findById(@PathVariable(name = "idCategorie") Long idCategorie) {
        if (idCategorie == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve categorie with null ID");
        }
        Categorie categorie = categorieService.findById(idCategorie);
        if (categorie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(categorie);
    }

    @GetMapping("/accueil")
    public ResponseEntity findCategorieAccueil() {
        List<Categorie> allAccueil = categorieService.filterAccueilCategorie();
        if (allAccueil == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(allAccueil);
    }

    @GetMapping("/sub/{association}")
    public ResponseEntity findListByAssociation(@PathVariable(name = "association") Long association) {
        if (association == null){
            return ResponseEntity.badRequest().body("Cannot retrieve association number");
        }
        List<Categorie> listAssociation = this.categorieService.findListByAssociation(association);
        if (listAssociation == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listAssociation);
    }

    @GetMapping("/all")
    public ResponseEntity findAllCategories() {
        List<Categorie> categorieList = categorieService.findAllCategories();
        if (categorieList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(categorieList);
    }
}
