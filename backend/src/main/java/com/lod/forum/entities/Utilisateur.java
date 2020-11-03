package com.lod.forum.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String mail;

    private String pseudo;

    private String mdp;

    @Lob
    private byte[] photo;

    private String rang;

    private int experience;

    private int argent;

    private Date created;

    @OneToMany
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private List<Post> posts;

    public Utilisateur() {
    }
}
