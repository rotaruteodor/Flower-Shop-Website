package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbackend.dto.ShoppingCartDto;
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
}
