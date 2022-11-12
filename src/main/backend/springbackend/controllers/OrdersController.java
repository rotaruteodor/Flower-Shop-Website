package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbackend.dto.OrderDto;
import springbackend.entities.Order;
import springbackend.services.OrderService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class OrdersController {

    private static final String ORDERS_MAIN_URL = "/orders";

    @Autowired
    private OrderService service;

    @GetMapping(ORDERS_MAIN_URL)
    public List<OrderDto> findAll(){
        return service.findAll();
    }

    @PostMapping(ORDERS_MAIN_URL + "/{userId}")
    public ResponseEntity<OrderDto> add(@RequestBody Order order, @PathVariable Long userId){
        System.out.println("entered");
        return service.add(order, userId);
    }
}
