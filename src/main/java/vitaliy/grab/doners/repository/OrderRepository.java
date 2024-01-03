package vitaliy.grab.doners.repository;

import org.springframework.data.repository.CrudRepository;
import vitaliy.grab.doners.model.DonerOrder;

/**
 * Oywayten 12.11.2023.
 */

public interface OrderRepository extends CrudRepository<DonerOrder, String> {
}
