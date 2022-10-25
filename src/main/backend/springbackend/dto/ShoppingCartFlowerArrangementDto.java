package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.FlowerArrangement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartFlowerArrangementDto {

    private Long id;
    private FlowerArrangement flowerArrangement;
    private Long quantity;

}
