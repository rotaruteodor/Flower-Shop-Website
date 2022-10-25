package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbackend.dto.OrderDto;
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
}
