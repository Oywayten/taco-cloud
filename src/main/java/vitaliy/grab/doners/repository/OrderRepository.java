package vitaliy.grab.doners.repository;

import org.springframework.data.repository.CrudRepository;
import vitaliy.grab.doners.model.DonerOrder;

import java.util.Date;
import java.util.List;

/**
 * Oywayten 12.11.2023.
 */

public interface OrderRepository extends CrudRepository<DonerOrder, Long> {

    List<DonerOrder> findByDeliveryZip(String deliveryZip);

    List<DonerOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
}
