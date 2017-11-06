package com.Anisoft.boutique1.dao;

import com.Anisoft.boutique1.entity.Client;
import javafx.collections.ObservableList;

/**
 *
 * @author Anisoft
 */
public interface ClientDao {
    public ObservableList<Client> getClients();
    public Client getClient(long id);
    public void saveClient(Client client);
    public void updateClient(Client client);
    public void deleteClient(Client client);
    public String getCompteBancaire(long id);
}
