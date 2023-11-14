package vitaliy.grab.doners.service;

import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.Order;
import vitaliy.grab.doners.repository.OrderRepository;

/**
 * Oywayten 13.11.2023.
 */
@Service
public class JdbcOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public JdbcOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
