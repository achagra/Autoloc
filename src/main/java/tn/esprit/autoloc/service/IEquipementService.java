package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;
import java.util.Optional;

public interface IEquipementService {
    List<Client> retrieveAllClients();
    Client addClient(Client c);
    Client updateClient(Client c);
    Optional<Client> retrieveClient(Long idClient);
    void removeClient(Long idClient);
    List<Client> addClients (List<Client> clients);
}
