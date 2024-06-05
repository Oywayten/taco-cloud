package vitaliy.grab.doners.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.repository.OrderRepository;

import java.util.List;

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
            + "|| returnObject.user.username == principal.username")
    public DonerOrder getOrder(long orderId) {
        return orderRepository.getDonerOrderById(orderId);
    }
	
	public List<DonerOrder> findByUserOrderByPlacedAtDesc (User user, Pageable pageable) {
		return orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
	}
}
