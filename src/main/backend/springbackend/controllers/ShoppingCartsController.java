package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbackend.dto.ShoppingCartDto;
import springbackend.dto.UserDto;
import springbackend.entities.ShoppingCart;
import springbackend.entities.User;
import springbackend.services.ShoppingCartService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class ShoppingCartsController {

    private static final String SHOPPING_CARTS_MAIN_URL = "/shopping-carts";
    private static final String SHOPPING_CARTS_ID_URL = SHOPPING_CARTS_MAIN_URL + "/{id}";

    @Autowired
    private ShoppingCartService service;

    @GetMapping(SHOPPING_CARTS_MAIN_URL)
    public List<ShoppingCartDto> findAll(){
        return service.findAll();
    }

    @PutMapping(SHOPPING_CARTS_ID_URL)
    public ResponseEntity<ShoppingCartDto> updateById(@PathVariable Long id, @RequestBody ShoppingCart shoppingCart) {
        return service.updateById(id, shoppingCart);
    }
}
