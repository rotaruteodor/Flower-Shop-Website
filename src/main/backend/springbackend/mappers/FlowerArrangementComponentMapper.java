package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.FlowerArrangementComponentDto;
import springbackend.entities.FlowerArrangementComponent;

@Mapper
public interface FlowerArrangementComponentMapper {
    FlowerArrangementComponentDto toDto(FlowerArrangementComponent flowerArrangementComponent);
}
