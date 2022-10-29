package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import springbackend.dto.UserDto;
import springbackend.entities.User;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.UserMapper;
import springbackend.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private UserMapper mapper;

    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(user -> mapper.toDto(user))
                .toList();
    }

    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(user -> mapper.toDto(user))
                .map(userDto -> ResponseEntity.ok(userDto))
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("User", id)));
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public ResponseEntity<UserDto> findByCredentials(@RequestParam String email,
                                                     @RequestParam Optional<String> password) {
        return password.map(pass -> repository.findByEmailAddressAndPassword(email, pass))
                .orElseGet(() -> repository.findByEmailAddress(email))
                .map(user -> mapper.toDto(user))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("error"));

//        Optional<User> userOptional = password == null ?
//                repository.findByEmailAddress(email) : repository.findByEmailAddressAndPassword(email, password);
//        if (userOptional.isPresent()) {
//            return ResponseEntity.ok(mapper.toDto(userOptional.get()));
//        }
//        throw new ResourceNotFoundException(ErrorMessage.getUserDoesNotExistErrorMessage(email));
    }

    public ResponseEntity<UserDto> add(@RequestBody User user) {
        repository.save(user);
        return ResponseEntity.ok(mapper.toDto(user));
    }

    public ResponseEntity<UserDto> updateById(@PathVariable Long id, @RequestBody User user) {
        User currentUser = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.getDoesNotExistErrorMessage("User", id)));

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmailAddress(user.getEmailAddress());
        currentUser.setPassword(user.getPassword());
        currentUser.setOrders(user.getOrders());
        currentUser.setShoppingCart(user.getShoppingCart());

        User updatedUser = repository.save(currentUser);

        UserDto userDto = mapper.toDto(updatedUser);
        return ResponseEntity.ok(userDto);
    }

    public ResponseEntity<UserDto> deleteById(@PathVariable Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("User", id)));
        repository.delete(user);

        UserDto userDto = mapper.toDto(user);
        return ResponseEntity.ok(userDto);
    }
}
