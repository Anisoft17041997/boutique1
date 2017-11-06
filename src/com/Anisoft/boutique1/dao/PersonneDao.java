package com.Anisoft.boutique1.dao;

import com.Anisoft.boutique1.entity.Personne;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface PersonneDao {
    public ObservableList<Personne> getPersonnes();
    public Personne getPersonne(long id);
    public void savepersonne(Personne personne);
    public void updatePersonne(Personne personne);
    public void deletepersonne(Personne personne);
}
