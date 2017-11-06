/*
 * Name : Employe.java
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
@DiscriminatorValue("E")
public class Employe extends Personne implements Serializable{
    @Column(name = "cin", nullable = true)
    private String cin;
    @Column(name = "cnss", nullable = true)
    private String cnss;
    
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "password")
    private String password;

    /************************* LES CONSTRUCTEURS *******************************/
    
    public Employe() {
    }

    public Employe(String cin, String cnss, Long id, String nom, String prenom, Date dateNaissance, String pseuso, String password) {
        super(id, nom, prenom, dateNaissance);
        this.cin = cin;
        this.cnss = cnss;
        this.pseudo = pseuso;
        this.password = password;
    }

    public Employe(String cin, String cnss, String nom, String prenom, Date dateNaissance, String pseuso, String password) {
        super(nom, prenom, dateNaissance);
        this.cin = cin;
        this.cnss = cnss;
        this.pseudo = pseuso;
        this.password = password;
    }
    
    /************************ LES GETTERS ET LES SETTERS ***********************/
    
    public String getCin() {
        return cin;
    }

    public String getCnss() {
        return cnss;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }
    
    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /******************************* LES METHODES ******************************/
    @Override
    public String toString() {
        return super.toString() 
                +"\n->Cin:"+getCin()
                +"\n->Cnss:"+getCnss(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
