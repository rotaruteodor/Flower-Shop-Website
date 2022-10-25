package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.ColorDto;
import springbackend.entities.Color;

@Mapper
public interface ColorMapper {
    ColorDto toDto(Color color);
}
