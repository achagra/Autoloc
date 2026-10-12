package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Client")
public class ClientController {
   private final IClientService clientService ;
   @PostMapping("/addClient")
   public Client addClient(@RequestBody Client c){
      return clientService.addClient(c);
   }
   @GetMapping("/getClients")
   public List<Client> getAllClients(){
      return clientService.retrieveAllClients();
   }
   @GetMapping("/getClients/{idc}")
   public Optional<Client> getclientbyid(@PathVariable long idc ){
      return clientService.retrieveClient(idc) ;
   }
   @DeleteMapping("/deleteClient/{idcc}")
   public void deleteClient(@PathVariable long idcc){
      clientService.removeClient(idcc);
   }
   @PutMapping("/updateClient")
   public Client updateClient (@RequestBody  Client c){
      return clientService.updateClient(c);
   }

}
