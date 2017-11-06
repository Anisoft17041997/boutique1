package com.Anisoft.boutique1.dao;

import com.Anisoft.boutique1.entity.ProduitAchete;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface ProduitAcheteDao {
    public ObservableList<ProduitAchete> getProduitAchetes();
    public ProduitAchete getProduitAchete(long id);
    public void saveProduitAchete(ProduitAchete produitAchete);
    public void updateProduitAchete(ProduitAchete produitAchete);
    public void deleteProduitAchete(ProduitAchete produitAchete);
}
