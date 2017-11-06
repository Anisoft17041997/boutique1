package com.Anisoft.boutique1.dao;

import com.Anisoft.boutique1.entity.Produit;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface ProduitDao {
    public ObservableList<Produit> getproduits();
    public Produit getProduit(long id);
    public void saveproduit(Produit produit);
    public void updateProduit(Produit produit);
    public void deleteProduit(Produit produit);
}
