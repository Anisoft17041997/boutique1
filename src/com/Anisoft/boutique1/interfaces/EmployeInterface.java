/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Anisoft.boutique1.interfaces;

import com.Anisoft.boutique1.entity.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface EmployeInterface {
    public ObservableList<Employe> EMPLOYELIST = FXCollections.observableArrayList();
}
