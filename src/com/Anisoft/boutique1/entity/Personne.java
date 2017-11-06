/*
 * Name : Personne.java
 * Author : Anisoft
 * Date : 04/11/2017
 */

package com.Anisoft.boutique1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anisoft
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", length = 7)
@DiscriminatorValue("P")
@Table(name = "personnes")
public class Personne implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "date_de_naissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;

    public Personne() {
    }

    public Personne(Long id, String nom, String prenom, Date dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    
     public Personne(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj == this){
            result = true;
        }else{
            if(!(obj instanceof Personne)){
                result = false;
            }else{
                Personne other = (Personne) obj;
                if(! this.id.equals(other.id)){
                    result = false;
                }
            }  
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return ("->Id:"+getId()
                +"\n->Nom:"+getNom()
                +"\n->Prenom:"+getPrenom()
                +"\n->Date de naissance:"+getDateNaissance()); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getAge(){
        return this.getAge(new Date());
    }
    
    public int getAge(Date dateReference){
        long duree = dateReference.getTime() - this.dateNaissance.getTime();
        return (int) duree / (1000 * 60 * 60 * 24 * 365); // ms * min * heure * jour * annee
    }
    
}
