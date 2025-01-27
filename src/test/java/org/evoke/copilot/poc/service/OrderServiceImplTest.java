package org.evoke.copilot.poc.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.evoke.copilot.poc.model.Order;
import org.evoke.copilot.poc.repository.OrderRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllOrders_returnsAllOrders() {
        Order order1 = new Order();
        order1.setId("1");
        Order order2 = new Order();
        order2.setId("2");
        List<Order> orders = Arrays.asList(order1, order2);

        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAllOrders();

        assertEquals(2, result.size());
        assertEquals("1", result.get(0).getId());
        assertEquals("2", result.get(1).getId());
    }

    @Test
    void createOrder_savesAndReturnsOrder() {
        Order order = new Order();
        order.setId("1");

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.createOrder(order);

        assertEquals("1", result.getId());
    }

    @Test
    void getAllOrders_returnsEmptyListWhenNoOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList());

        List<Order> result = orderService.getAllOrders();

        assertEquals(0, result.size());
    }

    @Test
    void createOrder_handlesNullOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(null);

        Order result = orderService.createOrder(null);

        assertEquals(null, result);
    }
}