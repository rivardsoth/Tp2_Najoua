package com.example.tp2_najoua.controlleur;

import com.example.tp2_najoua.entity.Payment;
import com.example.tp2_najoua.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentControl {

    private PaymentService paymentService;

    @Autowired
    public PaymentControl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments") //http://localhost:8080/payments
    public List<Payment> getAllPayment() {
        return paymentService.findall();
    }

    @GetMapping("/payments/{id}")//http://localhost:8080/instructors/1
    public Payment getPaymentById(@PathVariable("id") int id) {
        //va chercher le payment
        return paymentService.findPaymentById(id);

    }
    @DeleteMapping("/payments/{id}")
    //PathVariable sert a extraire un parametre du URL
    public ResponseEntity<String> deleteInstructeurById(@PathVariable int id) {
        boolean deleted = paymentService.deletePaymentById(id);
        if (deleted) {
            String message = "Payment avec ID " + id + " supprimé.";
            return ResponseEntity.ok(message);
        } else {
            String errorMessage = "Payment avec ID " + id + " n'existe pas.";
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
