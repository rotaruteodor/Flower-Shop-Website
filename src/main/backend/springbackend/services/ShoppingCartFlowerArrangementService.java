package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springbackend.dto.ShoppingCartFlowerArrangementDto;
import springbackend.dto.UserDto;
import springbackend.entities.ShoppingCartFlowerArrangement;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.ShoppingCartFlowerArrangementMapper;
import springbackend.repositories.FlowerArrangementsRepository;
import springbackend.repositories.ShoppingCartFlowerArrangementRepository;
import springbackend.repositories.ShoppingCartsRepository;

import java.util.List;

@Service
public class ShoppingCartFlowerArrangementService {

    @Autowired
    private ShoppingCartFlowerArrangementRepository shoppingCartFlowerArrangementRepository;

    @Autowired
    private ShoppingCartsRepository shoppingCartsRepository;

    @Autowired
    private FlowerArrangementsRepository flowerArrangementsRepository;

    @Autowired
    private ShoppingCartFlowerArrangementMapper mapper;

    public List<ShoppingCartFlowerArrangementDto> findAll() {
        return shoppingCartFlowerArrangementRepository.findAll()
                .stream()
                .map(scfa -> mapper.toDto(scfa))
                .toList();
    }

    public ResponseEntity<ShoppingCartFlowerArrangementDto> findById(@PathVariable Long id) {
        return shoppingCartFlowerArrangementRepository.findById(id)
                .map(scfa -> mapper.toDto(scfa))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("ShoppingCartFlowerArrangement", id)));
    }

    public ResponseEntity<ShoppingCartFlowerArrangementDto> add(@RequestBody ShoppingCartFlowerArrangement shoppingCartFlowerArrangement,
                                                                @PathVariable Long shoppingCartId,
                                                                @PathVariable Long flowerArrangementId) {
        shoppingCartsRepository.findById(shoppingCartId)
                .map(shoppingCart -> {
                    shoppingCartFlowerArrangement.setShoppingCart(shoppingCart);
                    return shoppingCart;
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("ShoppingCart", shoppingCartId)));

        flowerArrangementsRepository.findById(flowerArrangementId)
                .map(flowerArrangement -> {
                    shoppingCartFlowerArrangement.setFlowerArrangement(flowerArrangement);
                    return flowerArrangement;
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("FlowerArrangement", flowerArrangementId)));

        shoppingCartFlowerArrangementRepository.save(shoppingCartFlowerArrangement);
        return ResponseEntity.ok(mapper.toDto(shoppingCartFlowerArrangement));
    }
}

// todo kafka 2 services