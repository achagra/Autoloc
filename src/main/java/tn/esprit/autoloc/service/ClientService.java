package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

public class ClientService implements IClientService {
    ClientRepository clRepo ;
    @Override
    public List<Client> retrieveAllClients() {

        return (List<Client>) clRepo.findAll();
    }

    @Override
    public Client addClient(Client c) {

        return clRepo.save(c);
    }

    @Override
    public Client updateClient(Client c) {

        return clRepo.save(c);
    }

    @Override
    public Optional<Client> retrieveClient(Long idClient) {
        return Optional.ofNullable(clRepo.findById(idClient).orElse(null));
    }

    @Override
    public void removeClient(Long idClient) {
        clRepo.deleteById(idClient);

    }

    @Override
    public List<Client> addClients(List<Client> clients) {

        return (List<Client>) clRepo.saveAll(clients);
    }
}
