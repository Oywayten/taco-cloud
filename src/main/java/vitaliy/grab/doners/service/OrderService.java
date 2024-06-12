package vitaliy.grab.doners.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

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

    @PostAuthorize(
            "hasRole('ADMIN') || returnObject.isPresent() && returnObject.get().user.username == principal.username")
    public Optional<DonerOrder> findById(long orderId) {
        return orderRepository.findById(orderId);
    }
	
	public List<DonerOrder> findByUserOrderByPlacedAtDesc (User user, Pageable pageable) {
		return orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
	}
}
