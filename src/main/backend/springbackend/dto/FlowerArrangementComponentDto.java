package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.Color;
import springbackend.entities.FlowerArrangementComponentGeneralInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlowerArrangementComponentDto {

    private Long id;
    private FlowerArrangementComponentGeneralInfo individualProduct;
    private Color color;
    private Integer quantity;

}
