package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springbackend.dto.ShoppingCartDto;
import springbackend.entities.ShoppingCart;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.ShoppingCartMapper;
import springbackend.repositories.ShoppingCartsRepository;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartsRepository repository;

    @Autowired
    private ShoppingCartMapper mapper;

    public List<ShoppingCartDto> findAll() {
        return repository.findAll()
                .stream()
                .map(shoppingCart -> mapper.toDto(shoppingCart))
                .toList();
    }

    public ResponseEntity<ShoppingCartDto> updateById(@PathVariable Long id,
                                                      @RequestBody ShoppingCart shoppingCart) {
        var currentShoppingCart = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("ShoppingCart", id)));

        currentShoppingCart.setShoppingCartFlowerArrangements(shoppingCart.getShoppingCartFlowerArrangements());

        var updatedShoppingCart = repository.save(currentShoppingCart);

        var shoppingCartDto = mapper.toDto(updatedShoppingCart);
        return ResponseEntity.ok(shoppingCartDto);
    }
}
