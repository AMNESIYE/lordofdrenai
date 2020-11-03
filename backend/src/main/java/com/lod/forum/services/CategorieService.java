package com.lod.forum.services;

import com.lod.forum.entities.Categorie;
import com.lod.forum.repositories.ICategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private ICategorie categorieRepository;

    private int[] categorieArray= new int[]{1, 2, 3, 4};

    public Categorie findById(Long idCategorie){
        List<Categorie> tempCategorie = categorieRepository.findAll();
        if (idCategorie < 1 || idCategorie > tempCategorie.size()){
            return null;
        }
        Categorie categorie = categorieRepository.getOne(idCategorie);
        return categorie;
    }

    public List<Categorie> filterAccueilCategorie() {
        List<Categorie> allCategorie = new ArrayList<>();
        try {
            allCategorie = categorieRepository.findAll();
        }
        catch (Exception e){
            System.out.println(e);
        }
        List<Categorie> allAccueil = new ArrayList<Categorie>();
        try {
            for (Categorie categorie :
                    allCategorie) {
                for (int id :
                        categorieArray) {
                    if (categorie.getId() == id) {
                        allAccueil.add(categorie);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return allAccueil;
    }

    public List<Categorie> findListByAssociation(Long association) {
        List<Categorie> listAssociation = categorieRepository.findByAssociation(association);
        try {
            if (listAssociation != null && listAssociation.size() > 0 && listAssociation.get(0).getId() == association) {
                listAssociation.remove(0);
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return listAssociation;
    }

    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }
}
