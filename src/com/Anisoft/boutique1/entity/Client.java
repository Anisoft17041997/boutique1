/*
 * Name : Client.java
 * Author : Anisoft
 * Date : 04/11/2017
 */

package com.Anisoft.boutique1.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Anisoft
 */

@Entity
@DiscriminatorValue("C")
public class Client extends Personne implements Serializable{
    @Column(name = "compteBancaire", nullable = true)
    private String compteBancaire;

    /************************* LES CONSTRUCTEURS *******************************/
    
    public Client() {
    }

    public Client(String compteBancaire, Long id, String nom, String prenom, Date dateNaissance) {
        super(id, nom, prenom, dateNaissance);
        this.compteBancaire = compteBancaire;
    }
    
    public Client(String compteBancaire, String nom, String prenom, Date dateNaissance) {
        super(nom, prenom, dateNaissance);
        this.compteBancaire = compteBancaire;
    }
    
    /************************ LES GETTERS ET LES SETTERS ***********************/
    
    public String getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(String compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    /******************************* LES METHODES ******************************/
    @Override
    public String toString() {
        return super.toString() 
                + "\n->Compte Bancaire:" + getCompteBancaire(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
