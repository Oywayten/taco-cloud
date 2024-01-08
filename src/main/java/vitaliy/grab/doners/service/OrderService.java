package vitaliy.grab.doners.service;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.repository.OrderRepository;

/**
 * Oywayten 13.11.2023.
 */
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(DonerOrder donerOrder) {
        orderRepository.save(donerOrder);
    }

    @PostAuthorize("hasRole('ADMIN') "
            + "|| returnObject.user.username == authentication.name")
    public DonerOrder getOrder(long orderId) {
        return orderRepository.getDonerOrderById(orderId);
    }
}
