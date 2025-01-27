package org.evoke.copilot.poc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.evoke.copilot.poc.model.Order;
import org.evoke.copilot.poc.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void getAllOrders_returnsAllOrders() throws Exception {
        Order order1 = new Order();
        order1.setId("1");
        Order order2 = new Order();
        order2.setId("2");
        List<Order> orders = Arrays.asList(order1, order2);

        when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':'1'},{'id':'2'}]"));
    }

    @Test
    void createOrder_createsAndReturnsOrder() throws Exception {
        Order order = new Order();
        order.setId("1");

        when(orderService.createOrder(order)).thenReturn(order);

        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':'1'}"));
    }

    @Test
    void getAllOrders_returnsEmptyListWhenNoOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}