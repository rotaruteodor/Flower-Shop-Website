package springbackend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbackend.services.ShoppingCartFlowerArrangementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class ShoppingCartFlowerArrangementController {

    private ShoppingCartFlowerArrangementService service;
}
