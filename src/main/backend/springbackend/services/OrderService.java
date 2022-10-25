package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbackend.dto.OrderDto;
import springbackend.mappers.OrderMapper;
import springbackend.repositories.OrdersRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository repository;

    @Autowired
    private OrderMapper mapper;

    public List<OrderDto> findAll(){
        return repository.findAll()
                .stream()
                .map(order -> mapper.toDto(order))
                .toList();
    }
}
