package com.lod.forum.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categorie implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private Date created;

    private String image;

    private Long association;

    @OneToMany
    @JoinColumn(name = "id_categorie", referencedColumnName = "id")
    private List<Sujet> sujets;

    public Categorie(){

    }
}
