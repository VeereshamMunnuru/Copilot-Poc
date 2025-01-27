package org.evoke.copilot.poc.service;

import org.evoke.copilot.poc.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
}