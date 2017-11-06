/*
 * Name : Achat.java
 * Author : Anisoft
 * Date : 04/11/2017
 */

package com.Anisoft.boutique1.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anisoft
 */

@Entity
@Table(name = "achats")
public class Achat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "dateAchat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    @Column
    private double remise;
    @Column
    private List<ProduitAchete> produitAchete = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "clientId")
    private Client client;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employeId")
    private Employe employe;

    /************************* LES CONSTRUCTEURS *******************************/
    
    public Achat() {
    }

    public Achat(long id, Date dateAchaDate, double remise, Client client, Employe employe) {
        this.id = id;
        this.dateAchat = dateAchaDate;
        this.remise = remise;
        this.client = client;
        this.employe = employe;
    }
    
    public Achat(Date dateAchaDate, double remise, Client client, Employe employe) {
        this.dateAchat = dateAchaDate;
        this.remise = remise;
        this.client = client;
        this.employe = employe;
    }
    
    /************************ LES GETTERS ET LES SETTERS ***********************/
    
    public long getId() {
        return id;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public double getRemise() {
        return remise;
    }

    public Client getClient() {
        return client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<ProduitAchete> getProduitAchete() {
        return produitAchete;
    }

    public void setProduitAchete(List<ProduitAchete> produitAchete) {
        this.produitAchete = produitAchete;
    }
    
    
    
    /******************************* LES METHODES ******************************/

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj == this){
            result = true;
        }else{
            if(!(obj instanceof Achat)){
                result = false;
            }else{
                Achat other = (Achat) obj;
                if(!this.id.equals(other.id)){
                    result = false;
                }
            }
        }
                
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return ("->ID:"+getId()
                +"\n->Date d'achat:"+getDateAchat()
                +"\n->Remise:"+getRemise()
                +"\n->Client:"+getClient()
                +"\n->Employe:"+getEmploye()); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getPrixTotal(){
        double prix = 0.0;
        for(ProduitAchete p : this.produitAchete){
            prix += p.getPrixTotal();
        }
        return prix - this.remise;
    }
    
    public double getRemiseTotal(){
        double remise = 0.0;
        for(ProduitAchete r : this.produitAchete){
            remise += r.getRemise();
        }
        return remise + this.remise;
    }
    
}
