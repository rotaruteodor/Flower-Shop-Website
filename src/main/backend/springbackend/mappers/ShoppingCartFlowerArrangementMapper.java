package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.ShoppingCartFlowerArrangementDto;
import springbackend.entities.ShoppingCartFlowerArrangement;

@Mapper
public interface ShoppingCartFlowerArrangementMapper {
    ShoppingCartFlowerArrangementDto toDto(ShoppingCartFlowerArrangement shoppingCartFlowerArrangement);
}
