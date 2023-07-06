package tse.de3.myproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;

@Entity
public class Joueur {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nom;
 private String poste;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "equipe_id")
 @JsonIgnore
 private Equipe equipe;

 // Getters
 public Long getId() {
     return id;
 }

 public String getNom() {
     return nom;
 }

 public String getPoste() {
     return poste;
 }

 public Equipe getEquipe() {
     return equipe;
 }

 // Setters
 public void setId(Long id) {
     this.id = id;
 }

 public void setNom(String nom) {
     this.nom = nom;
 }

 public void setPoste(String poste) {
     this.poste = poste;
 }

 public void setEquipe(Equipe equipe) {
     this.equipe = equipe;
 }
}
