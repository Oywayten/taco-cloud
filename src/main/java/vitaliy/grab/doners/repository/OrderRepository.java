package vitaliy.grab.doners.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.model.User;

import java.util.List;

/**
 * Oywayten 12.11.2023.
 */

public interface OrderRepository extends CrudRepository<DonerOrder, Long> {

    List<DonerOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
