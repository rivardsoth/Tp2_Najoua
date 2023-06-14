package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.ClientOrder;
import com.example.tp2_najoua.entity.OrderItem;
import com.example.tp2_najoua.entity.Payment;
import com.example.tp2_najoua.repository.ClientOrderRepository;
import com.example.tp2_najoua.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired //pas besoin de faire un new
    private PaymentRepository paymentRepository;
    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Override
    public List<Payment> findall() {
        return paymentRepository.findAll();
    }

    @Override
    public boolean deletePaymentById(int id) {
        Payment tempPayment = this.findPaymentById(id);
        if (tempPayment != null) {
            //get ClientOrder
            ClientOrder clientOrder = tempPayment.getClientOrder();

            if (clientOrder != null) {
                clientOrder.setPayment(null);
                clientOrderRepository.save(clientOrder);
            }
            tempPayment.setClientOrder(null);
            paymentRepository.save(tempPayment);
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Payment findPaymentById(int id) {
        return paymentRepository.findById(id).get();
    }
}
