package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.Payment;
import com.example.tp2_najoua.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired //pas besoin de faire un new
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> findall() {
        return paymentRepository.findAll();
    }
}
