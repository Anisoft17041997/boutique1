/*
 * Name : Produit.java
 * Author : Anisoft
 * Date : 04/11/2017
 */

package com.Anisoft.boutique1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anisoft
 */

@Entity
@Table(name = "produits")
public class Produit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "libelle")
    private String libelle;
    
    @Column(name = "prixUnitaire")
    private double prixUnitaire;
    
    @Column(name = "datePeremption")
    @Temporal(TemporalType.DATE)
    private Date datePeremption;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie", nullable = false)
    private Categorie categorie;
    
    /************************* LES CONSTRUCTEURS *******************************/
    
    public Produit() {
    }

    public Produit(Long id, String libelle, double prixUnitaire, Date datePeremption, Categorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
        this.categorie = categorie;
    }
    
    public Produit(String libelle, double prixUnitaire, Date datePeremption, Categorie categorie) {
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
        this.categorie = categorie;
    }    
    
    /************************ LES GETTERS ET LES SETTERS
     * @return  ***********************/
    
    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public Categorie getCategorie() {
        return categorie;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /******************************* LES METHODES ******************************/
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj == this){
            result = true;
        }else{
            if(!(obj instanceof Produit)) {
                result = false;
            }else{
                Produit other = (Produit) obj;
                if(!this.id.equals(other.id)) {
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
        return ("->Id:"+getId()
                +"\n->Libelle:"+getLibelle()
                +"\n->Prix unitaire:"+getPrixUnitaire()
                +"\n->Date de permption:"+getDatePeremption()
                +"\n->Categorie:"+getCategorie()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Renvoie <code>true</code> si le produit courant est périmé par rapport à 
     * la date courante.
     * 
     * @return <code>true</code> si le produit courant est périmé par rapport a 
     * la date courante.
     */
    public boolean estPerime() {
        return this.estPerime(new Date());
    }
    
    /**
     * Renvoie <code>true</code> si le produit courant est périmé par rapport à 
     * la date passé en paramètre.
     * 
     * @param dateReference La date par rapport a laquelle vérifier
     * la peremption.
     * @return <code>true</code> si le produit courant est périmé par rapport a 
     * la <code>datRefernce</code>.
     * @throws IllegalArgumentException quand <code>dateReference</code> est 
     * <code>null</code>.
     */
    public boolean estPerime(Date dateReference) {
        if (dateReference == null) {
            throw new IllegalArgumentException("datePeremption est null");
        }
        if (this.datePeremption == null) {
            return false;
        }
        //on pourra donc pas arriver ici si on a la dateReference et datePeremption null
        return dateReference.after(this.datePeremption);
    }
    
}
