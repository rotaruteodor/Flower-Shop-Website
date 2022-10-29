package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.FlowerArrangement;
import springbackend.entities.ShoppingCartFlowerArrangement;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartDto {
    private Long id;
    private List<ShoppingCartFlowerArrangementDto> shoppingCartFlowerArrangements;

    private BigDecimal totalPrice;
}
