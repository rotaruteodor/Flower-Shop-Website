package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbackend.dto.UserDto;
import springbackend.entities.User;
import springbackend.services.UserService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class UsersController {

    private static final String USERS_MAIN_URL = "/users";
    private static final String USERS_ID_URL = USERS_MAIN_URL + "/{id}";

    @Autowired
    private UserService service;

    @GetMapping(USERS_MAIN_URL)
    public List<UserDto> findAll() {
        return service.findAll();
    }

    @GetMapping(USERS_ID_URL)
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(USERS_MAIN_URL + "/findByCredentials")
    public ResponseEntity<UserDto> findByCredentials(@RequestParam String email,
                                                     @RequestParam(required = false) String password) {
        return service.findByCredentials(email, password);
    }

    @PostMapping(USERS_MAIN_URL)
    public ResponseEntity<UserDto> add(@RequestBody User user) {
        return service.add(user);
    }

    @PutMapping(USERS_ID_URL)
    public ResponseEntity<UserDto> updateById(@PathVariable Long id, @RequestBody User user) {
        return service.updateById(id, user);
    }

    @DeleteMapping(USERS_ID_URL)
    public ResponseEntity<UserDto> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

}
