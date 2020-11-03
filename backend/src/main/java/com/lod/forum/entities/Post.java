package com.lod.forum.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String texte;

    @Column(name = "id_utilisateur")
    private Long idUtilisateur;

    @Column(name = "id_sujet")
    private Long idSujet;

    private Date created;

    public Post(){

    }
}