package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.Color;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlowerArrangementComponentDto {

    private Long id;
    private FlowerArrangementComponentGeneralInfoDto flowerArrangementComponentGeneralInfo;
    private Color color;
    private Integer quantity;

}
