package com.lod.forum.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sujet implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    @Column(name = "id_categorie")
    private Long idCategorie;

    private int type;

    private Date created;

    @OneToMany
    @JoinColumn(name = "id_sujet", referencedColumnName = "id")
    private List<Post> posts;

    public Sujet(){

    }
}