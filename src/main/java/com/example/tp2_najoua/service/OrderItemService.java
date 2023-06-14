package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> findall();

    boolean deleteOrderItemById(int id);

    OrderItem findOrderItemById(int id);
}
