package com.example.tp2_najoua.controlleur;

import com.example.tp2_najoua.entity.Client;
import com.example.tp2_najoua.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientControl {

    private ClientService clientService;
    @Autowired
    public ClientControl(ClientService clientService) {
        this.clientService = clientService;
    }

    /*@GetMapping("/clients") //http://localhost:8080/clients
    public List<Client> getAllClient() {
        return clientService.findall();
    }*/

    @GetMapping("/clients") //http://localhost:8080/clients
    public String getAllClient(Model model) {

        List<Client> entities = clientService.findall();
        model.addAttribute("entities", entities);
        return "clients";

    }

    @GetMapping("/clients/{id}")//http://localhost:8080/instructors/1
    public Client getClientById(@PathVariable("id") int id) {
            //va chercher le client
            return clientService.findClientById(id);

    }
    @DeleteMapping("/clients/{id}")
    //PathVariable sert a extraire un parametre du URL
    public ResponseEntity<String> deleteClientById(@PathVariable int id) {
        boolean deleted = clientService.deleteClientById(id);
        if (deleted) {
            String message = "Client avec ID " + id + " supprimé.";
            return ResponseEntity.ok(message);
        } else {
            String errorMessage = "Client avec ID " + id + " n'existe pas.";
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    @PostMapping("/clientes")
    public ResponseEntity<Client> saveInstructor(@RequestBody Client newClient) {
        Client savedClient = clientService.ajouterNouveauClient(newClient);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
}
