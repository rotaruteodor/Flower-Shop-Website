package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import springbackend.dto.OrderDto;
import springbackend.entities.Order;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.OrderMapper;
import springbackend.repositories.OrdersRepository;
import springbackend.repositories.UsersRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrderMapper mapper;

    public List<OrderDto> findAll(){
        return ordersRepository.findAll()
                .stream()
                .map(order -> mapper.toDto(order))
                .toList();
    }

    public ResponseEntity<OrderDto> add(@RequestBody Order order, @PathVariable Long userId){
        System.out.println(order.toString());
        return usersRepository.findById(userId)
                .map(u -> {
                    order.setUser(u);
                    ordersRepository.save(order);
                    return ResponseEntity.ok(mapper.toDto(order));
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("User", userId)));
    }
}
