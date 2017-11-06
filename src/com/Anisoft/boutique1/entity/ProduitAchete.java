/*
 * Name : ProduitAchete.java
 * Author : Anisoft
 * Date : 04/11/2017
 */

package com.Anisoft.boutique1.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anisoft
 */

@Entity
@Table(name = "produitAchetes")
public class ProduitAchete implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "remise")
    private double remise;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "produitId")
    private Produit produit;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "achatId")
    private Achat achat;

    /************************* LES CONSTRUCTEURS *******************************/
    
    public ProduitAchete() {
    }

    public ProduitAchete(int quantite, double remise) {
        this.quantite = quantite;
        this.remise = remise;
    }
    
    /************************ LES GETTERS ET LES SETTERS ***********************/

    public Produit getProduit() {
        return produit;
    }

    public Achat getAchat() {
        return achat;
    }
    
    public int getQuantite() {
        return quantite;
    }

    public double getRemise() {
        return remise;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }
    
    /******************************* LES METHODES ******************************/
    //la cle est la reunion des cles de produit et celle de achat
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj == this){
            result = true;
        }else{
            if(!(obj instanceof ProduitAchete)){
                result = false;
            }else{
                Produit p = (Produit) obj;
                Achat a = (Achat) obj;
                if(!this.produit.getId().equals(p.getId()) && 
                        !(this.achat.getId() == a.getId())){
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(produit.getId()) + Objects.hashCode(achat.getId());
        
        return hash; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return ("\n->Quantite:"+getQuantite()
                +"\n->Remise:"+getRemise()
                +"\n->Produit:"+getProduit()
                +"\n->Achat:"+getAchat()); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getPrixTotal(){
        return produit.getPrixUnitaire()*quantite - remise;
    }
    
}
