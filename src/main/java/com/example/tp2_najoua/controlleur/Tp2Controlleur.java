package com.example.tp2_najoua.controlleur;

import com.example.tp2_najoua.entity.*;
import com.example.tp2_najoua.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Tp2Controlleur {

    private ClientOrderService clientOrderService;
    private ClientService clientService;
    private LivreService livreService;
    private OrderItemService orderItemService;
    private PaymentService paymentService;

    public Tp2Controlleur() {
    }

    @Autowired
    public Tp2Controlleur(ClientOrderService clientOrderService, ClientService clientService, LivreService livreService, OrderItemService orderItemService, PaymentService paymentService) {
        this.clientOrderService = clientOrderService;
        this.clientService = clientService;
        this.livreService = livreService;
        this.orderItemService = orderItemService;
        this.paymentService = paymentService;
    }

    @GetMapping("/clients") //http://localhost:8080/clients
    public List<Client> getAllClient() {
        return clientService.findall();
    }

    @GetMapping("/livres") //http://localhost:8080/livres
    public List<Livre> getAllLivre() {
        return livreService.findall();
    }

    @GetMapping("/clientOrders") //http://localhost:8080/clientOrders
    public List<ClientOrder> getAllClientOrders() {
        return clientOrderService.findall();
    }

    @GetMapping("/orderItems") //http://localhost:8080/orderItems
    public List<OrderItem> getAllOrderItem() {
        return orderItemService.findall();
    }

    @GetMapping("/payments") //http://localhost:8080/payments
    public List<Payment> getAllPayment() {
        return paymentService.findall();
    }
}
