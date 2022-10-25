package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.Order;
import springbackend.entities.ShoppingCart;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private List<Order> orders;
    private ShoppingCart shoppingCart;
}
