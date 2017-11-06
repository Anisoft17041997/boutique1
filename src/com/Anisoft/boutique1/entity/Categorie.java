/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Anisoft.boutique1.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Anisoft
 */

@Entity
@Table(name="categories")
public class Categorie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "description")
    private Double description;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
    private List<Produit> produits;
    

    /************************* LES CONSTRUCTEURS *******************************/
    
    public Categorie() {
    }

    public Categorie(Integer id, String libelle, Double description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }
    
    public Categorie( String libelle, Double description) {
        this.libelle = libelle;
        this.description = description;
    }
    
    /************************ LES GETTERS ET LES SETTERS ***********************/
    
    public Integer getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public Double getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(Double description) {
        this.description = description;
    }

    /******************************* LES METHODES ******************************/
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj == this){
            result = true;
        }else{
            if(!(obj instanceof Categorie)){
                result = false;
            }else{
                Categorie other = (Categorie) obj;
                if(!this.id.equals(other.id)){
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7; // le choix est aléatoire mais éloigné des entiers.
        hash = 41 * hash + Objects.hashCode(this.id);// on fait une translation 
                                 //pour ne pas avoir une même valeur des objets.
        return hash;
    }

    @Override
    public String toString() {
        return ("->Id:"+getId()
                +"\n->Libelle:"+getLibelle()
                +"\n->Description:"+getDescription()); //To change body of 
                                  //generated methods, choose Tools | Templates.
    }
    
    
}
