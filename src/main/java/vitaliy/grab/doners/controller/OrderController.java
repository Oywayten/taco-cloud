package vitaliy.grab.doners.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.service.OrderService;

/**
 * Oywayten 08.11.2023.
 */

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("donerOrder")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid DonerOrder donerOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        orderService.save(donerOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}

