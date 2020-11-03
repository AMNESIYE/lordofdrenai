package com.lod.forum.services;

import com.lod.forum.entities.Sujet;
import com.lod.forum.repositories.ISujet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetService {
    @Autowired
    private ISujet sujetRepository;

    public List<Sujet> findSujetsByCategorie(Long idCategorie) {
        return sujetRepository.findByIdCategorie(idCategorie);
    }

    public Sujet findBySujet(Long idSujet) {
        List<Sujet> tempSujet = sujetRepository.findAll();
        if(idSujet < 1 || idSujet > tempSujet.size()){
            return null;
        }
        return sujetRepository.getOne(idSujet);
    }

    public List<Sujet> findAllSujets() {
        return sujetRepository.findAll();
    }
}
