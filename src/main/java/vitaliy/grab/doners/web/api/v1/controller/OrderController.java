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

    public static final String ORDER_WITH_ID_NOT_FOUND = "Order with id {0} not found";
    private final OrderService orderService;

    @PatchMapping(value = "/{orderId}", consumes = "application/json")
    public DonerOrder updateOrderById(@PathVariable long orderId, @RequestBody DonerOrder patch) {
        Optional<DonerOrder> optionalDonerOrder = orderService.findById(orderId);
        DonerOrder order = optionalDonerOrder.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                MessageFormat.format(ORDER_WITH_ID_NOT_FOUND, orderId)));
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

    @DeleteMapping("{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderById(@PathVariable long orderId) {
        orderService.deleteOrderById(orderId);
    }
}
