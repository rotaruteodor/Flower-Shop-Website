package spring_backend.controllers;

import spring_backend.entities.Order;
import spring_backend.entities.User;
import spring_backend.exceptions.ResourceNotFoundException;
import spring_backend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Track;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop_backend/v1")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:"
                        .concat(id.toString())
                        .concat(" doesn't exist")));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/findByCredentials")
    public ResponseEntity<User> getUserByCredentials(@RequestParam String email,
                                                     @RequestParam(required = false) String password) {
        User user = usersRepository
                .findAll()
                .stream()
                .filter(u -> u.getEmailAddress().equals(email) &&
                                (password == null || u.getPassword().equals(password)))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = usersRepository.findById(userId).map(User::getOrders)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:"
                        .concat(userId.toString())
                        .concat(" doesn't exist")));
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return usersRepository.save(user);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User currentUser = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: "
                        .concat(user.toString())
                        .concat(" doesn't exist")));

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmailAddress(user.getEmailAddress());
        currentUser.setPassword(user.getPassword());
        currentUser.setOrders(user.getOrders());
        currentUser.setShoppingCart(user.getShoppingCart());

        User updatedUser = usersRepository.save(currentUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId){
        User user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: "
                        .concat(userId.toString())
                        .concat("doesn't exist")));
        usersRepository.delete(user);
        return ResponseEntity.ok(user);
    }
}
