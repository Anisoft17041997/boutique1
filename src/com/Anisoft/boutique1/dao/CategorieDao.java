package com.Anisoft.boutique1.dao;

import com.Anisoft.boutique1.entity.Categorie;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface CategorieDao {
    public ObservableList<Categorie> getCategories();
    public Categorie getCategorie(long id);
    public void saveCategorie(Categorie categorie);
    public void updateCategorie(Categorie categorie);
    public void deleteCategorie(Categorie categorie);
    public ObservableList<String> getLibelles();
} 
