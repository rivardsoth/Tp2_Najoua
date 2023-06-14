package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.Client;
import com.example.tp2_najoua.entity.ClientOrder;
import com.example.tp2_najoua.entity.OrderItem;
import com.example.tp2_najoua.entity.Payment;
import com.example.tp2_najoua.repository.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientOrderServiceImpl implements ClientOrderService{

    @Autowired //pas besoin de faire un new
    private ClientOrderRepository clientOrderRepository;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private PaymentService paymentService;
    @Override
    public List<ClientOrder> findall() {
        return clientOrderRepository.findAll();
    }

    @Override
    public boolean deleteClientOrderById(int id) {
        ClientOrder tempClientOrder = this.findClientOrderById(id);
        if (tempClientOrder != null) {
            //effacer tous la liste de itemOrders du client
            List<OrderItem> liste = tempClientOrder.getOrderItems();
            if (liste != null) {
                for (OrderItem orderItem: liste){
                    orderItemService.deleteOrderItemById(orderItem.getId());
                }
                tempClientOrder.setOrderItems(null);
            }
            //effacer le payment du client
            Payment payment = tempClientOrder.getPayment();
            if (payment != null) {
                paymentService.deletePaymentById(payment.getPaymentId());
                tempClientOrder.setPayment(null);
            }
            //mettre le client a null
            tempClientOrder.setClient(null);

            clientOrderRepository.save(tempClientOrder);
            clientOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ClientOrder findClientOrderById(int id) {
        return clientOrderRepository.findById(id).get();
    }
}
