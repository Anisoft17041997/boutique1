package com.Anisoft.boutique1.dao;

import com.Anisoft.boutique1.entity.Employe;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface EmployeDao {
    public ObservableList<Employe> getEmploye();
    public Employe getEmploye(long id);
    public void saveEmploye(Employe employe);
    public void updateEmploye(Employe employe);
    public void deleteEmploye(Employe employe);
    public boolean checkPseudo(String pseudo);
    public boolean checkPassword(String pseudo, String password);
}
