package com.Anisoft.boutique1.dao;

import com.Anisoft.boutique1.entity.Achat;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface AchatDao {
    public ObservableList<Achat> getAchats();
    public Achat getAchat(long id);
    public void saveAchat(Achat achat);
    public void deleteAchat(Achat achat);
}
