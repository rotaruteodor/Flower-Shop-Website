package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbackend.mappers.ShoppingCartFlowerArrangementMapper;
import springbackend.repositories.ShoppingCartFlowerArrangementRepository;

@Service
public class ShoppingCartFlowerArrangementService {

    @Autowired
    private ShoppingCartFlowerArrangementRepository repository;

    @Autowired
    private ShoppingCartFlowerArrangementMapper mapper;
}
