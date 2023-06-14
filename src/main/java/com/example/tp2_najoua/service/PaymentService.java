package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.OrderItem;
import com.example.tp2_najoua.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findall();

    boolean deletePaymentById(int id);

    Payment findPaymentById(int id);
}
