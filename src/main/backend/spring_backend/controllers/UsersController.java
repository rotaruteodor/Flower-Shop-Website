package spring_backend.controllers;

import spring_backend.entities.Order;
import spring_backend.entities.User;
import spring_backend.exceptions.ResourceNotFoundException;
import spring_backend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/floweshop_backend/v1")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<User> getAll(){
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:"
                        .concat(id.toString())
                        .concat("doesn't exist")));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = usersRepository.findById(userId).map(User::getOrders)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:"
                        .concat(userId.toString())
                        .concat("doesn't exist")));
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        return usersRepository.save(user);
    }


}
