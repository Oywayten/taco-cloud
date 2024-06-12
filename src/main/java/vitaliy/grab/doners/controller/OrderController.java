package vitaliy.grab.doners.controller;

import jakarta.validation.Valid;
import vitaliy.grab.doners.configuration.OrderProperties;
import vitaliy.grab.doners.model.DonerOrder;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.service.OrderService;
import vitaliy.grab.doners.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;
import java.util.Optional;

/**
 * Oywayten 08.11.2023.
 */

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("donerOrder")
@AllArgsConstructor
public class OrderController {

    private static final int PAGE_NUMBER = 0;
    private final OrderProperties properties;
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
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<DonerOrder> findOrderById(@PathVariable long orderId) {
        Optional<DonerOrder> optionalDonerOrder = orderService.findById(orderId);
        return optionalDonerOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ModelAttribute(name = "donerOrder")
    public DonerOrder order() {
        return new DonerOrder();
    }

    @GetMapping
    public String findOrdersByUser(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(PAGE_NUMBER, properties.getPageSize());
        model.addAttribute("orders", orderService.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }

}

