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

    public DonerOrder save(DonerOrder donerOrder) {
        return orderRepository.save(donerOrder);
    }

    // FIXME: 14.06.2024 resolve @PostAuthorize issue and repair it
    public Optional<DonerOrder> findById(long orderId) {
        return orderRepository.findById(orderId);
    }

	public List<DonerOrder> findByUserOrderByPlacedAtDesc (User user, Pageable pageable) {
		return orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
	}
}
