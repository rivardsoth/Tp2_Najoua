package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.OrderItem;
import com.example.tp2_najoua.repository.OrderItemRepository;
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
}
