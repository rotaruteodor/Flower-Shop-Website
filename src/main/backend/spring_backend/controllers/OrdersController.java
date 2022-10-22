package spring_backend.controllers;

import spring_backend.entities.Order;
import spring_backend.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/floweshop_backend/v1")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/orders")
    public List<Order> getAll(){
        return ordersRepository.findAll();
    }
}
