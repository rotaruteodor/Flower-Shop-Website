package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbackend.dto.ShoppingCartFlowerArrangementDto;
import springbackend.dto.UserDto;
import springbackend.entities.ShoppingCartFlowerArrangement;
import springbackend.entities.User;
import springbackend.services.ShoppingCartFlowerArrangementService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class ShoppingCartFlowerArrangementController {


    private static final String SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL = "/shopping-cart-flower-arrangements";
    private static final String SHOPPING_CART_FLOWER_ARRANGEMENT_ID_URL = SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL
            + "/{id}";


    @Autowired
    private ShoppingCartFlowerArrangementService service;

    @GetMapping(SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL)
    public List<ShoppingCartFlowerArrangementDto> findAll() {
        return service.findAll();
    }

    @GetMapping(SHOPPING_CART_FLOWER_ARRANGEMENT_ID_URL)
    public ResponseEntity<ShoppingCartFlowerArrangementDto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL + "/{shoppingCartId}" + "/{flowerArrangementId}")
    public ResponseEntity<ShoppingCartFlowerArrangementDto> add(@RequestBody ShoppingCartFlowerArrangement shoppingCartFlowerArrangement,
                                                                @PathVariable Long shoppingCartId,
                                                                @PathVariable Long flowerArrangementId) {
        return service.add(shoppingCartFlowerArrangement, shoppingCartId, flowerArrangementId);
    }

}
