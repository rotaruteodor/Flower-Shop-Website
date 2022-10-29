package springbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.FlowerArrangement;
import springbackend.entities.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private LocalDate creationDate;
    private OrderStatus status;
    private List<FlowerArrangementDto> flowerArrangements;

}
