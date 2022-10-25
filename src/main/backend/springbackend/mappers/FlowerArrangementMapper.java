package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.FlowerArrangementDto;
import springbackend.entities.FlowerArrangement;

@Mapper
public interface FlowerArrangementMapper {
    FlowerArrangementDto toDto(FlowerArrangement flowerArrangement);
}
