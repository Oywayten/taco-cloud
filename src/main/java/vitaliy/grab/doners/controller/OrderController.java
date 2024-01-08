package vitaliy.grab.doners.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.service.OrderService;
import vitaliy.grab.doners.service.UserService;

import java.security.Principal;

/**
 * Oywayten 08.11.2023.
 */

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("donerOrder")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid DonerOrder donerOrder, Errors errors, SessionStatus sessionStatus, Principal principal) {

        if (errors.hasErrors()) {
            return "orderForm";
        }
        User user = userService.findByUsername(principal.getName());
        donerOrder.setUser(user);
        orderService.save(donerOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<DonerOrder> getOrder(@PathVariable long orderId) {
        ResponseEntity<DonerOrder> response = ResponseEntity.notFound().build();
        DonerOrder order = orderService.getOrder(orderId);
        if (order != null) {
            response = ResponseEntity.ok(order);
        }
        return response;
    }
}

