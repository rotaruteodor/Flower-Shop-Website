package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.ShoppingCartDto;
import springbackend.entities.ShoppingCart;

@Mapper
public interface ShoppingCartMapper {
    ShoppingCartDto toDto(ShoppingCart shoppingCart);
}
