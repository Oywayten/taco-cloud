package vitaliy.grab.doners.repository;

import org.springframework.data.repository.CrudRepository;
import vitaliy.grab.doners.model.DonerOrder;

import java.util.UUID;

/**
 * Oywayten 12.11.2023.
 */

public interface OrderRepository extends CrudRepository<DonerOrder, UUID> {
}
