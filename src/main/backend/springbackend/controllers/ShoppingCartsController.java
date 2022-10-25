package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbackend.dto.ShoppingCartDto;
import springbackend.services.ShoppingCartService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class ShoppingCartsController {

    private static final String SHOPPING_CARTS_MAIN_URL = "/shopping-carts";

    @Autowired
    private static ShoppingCartService service;
    @GetMapping(SHOPPING_CARTS_MAIN_URL)
    public List<ShoppingCartDto> findAll(){
        return service.findAll();
    }
}
