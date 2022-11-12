package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.FlowerArrangement;
import springbackend.entities.User;
import springbackend.entities.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private LocalDateTime creationDate;
    private OrderStatus status;
    private String deliveryAddress;
    private User user;
    private List<ShoppingCartFlowerArrangementDto> shoppingCartFlowerArrangements;

}
