package org.evoke.copilot.poc.repository;

import org.evoke.copilot.poc.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}