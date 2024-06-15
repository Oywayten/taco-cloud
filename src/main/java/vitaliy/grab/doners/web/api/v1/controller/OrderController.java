package vitaliy.grab.doners.web.api.v1.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.service.OrderService;

import java.text.MessageFormat;
import java.util.Optional;

@RestController("orderApiController")
@AllArgsConstructor
@RequestMapping(value = "/api/v1/orders", produces = "application/json")
public class OrderController {

    private final OrderService orderService;

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public DonerOrder updateOrderById(@PathVariable long id, @RequestBody DonerOrder patch) {
        Optional<DonerOrder> optionalDonerOrder = orderService.findById(id);
        DonerOrder order = optionalDonerOrder.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                MessageFormat.format("Id {0} not found in orders", id)));
        patchOrdersFields(patch, order);
        return orderService.save(order);
    }

    private static void patchOrdersFields(DonerOrder patch, DonerOrder order) {
        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
    }
}
