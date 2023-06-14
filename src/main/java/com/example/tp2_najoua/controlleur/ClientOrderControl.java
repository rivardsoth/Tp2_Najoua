package com.example.tp2_najoua.controlleur;

import com.example.tp2_najoua.entity.ClientOrder;
import com.example.tp2_najoua.entity.OrderItem;
import com.example.tp2_najoua.service.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientOrderControl {

    private ClientOrderService clientOrderService;

    @Autowired
    public ClientOrderControl(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @GetMapping("/clientOrders") //http://localhost:8080/clientOrders
    public List<ClientOrder> getAllClientOrders() {
        return clientOrderService.findall();
    }

    @GetMapping("/clientOrders/{id}")//http://localhost:8080/instructors/1
    public ClientOrder getClientOrderById(@PathVariable("id") int id) {
        //va chercher le clientOrder
        return clientOrderService.findClientOrderById(id);

    }
    @DeleteMapping("/clientOrders/{id}")
    //PathVariable sert a extraire un parametre du URL
    public ResponseEntity<String> deleteClientOrderById(@PathVariable int id) {
        boolean deleted = clientOrderService.deleteClientOrderById(id);
        if (deleted) {
            String message = "OrderItem avec ID " + id + " supprimé.";
            return ResponseEntity.ok(message);
        } else {
            String errorMessage = "OrderItem avec ID " + id + " n'existe pas.";
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
