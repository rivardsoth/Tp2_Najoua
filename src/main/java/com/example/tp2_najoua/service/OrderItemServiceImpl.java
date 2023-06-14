package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.OrderItem;
import com.example.tp2_najoua.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired //pas besoin de fair un new
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findall() {
        return orderItemRepository.findAll();
    }


    @Override
    public boolean deleteOrderItemById(int id) {
        OrderItem tempOrderItem = this.findOrderItemById(id);
        if (tempOrderItem != null) {
            tempOrderItem.setLivre(null);
            tempOrderItem.setClientOrder(null);
            orderItemRepository.save(tempOrderItem);
            orderItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public OrderItem findOrderItemById(int id) {
        OrderItem tempOrderItem = orderItemRepository.findById(id).get();
        return tempOrderItem;
    }
}
