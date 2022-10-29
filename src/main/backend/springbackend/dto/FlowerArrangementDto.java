package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.FlowerArrangementComponent;
import springbackend.entities.enums.FlowerArrangementType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlowerArrangementDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private FlowerArrangementType type;
    private String imageUrl;
    private List<FlowerArrangementComponentDto> components;

}
