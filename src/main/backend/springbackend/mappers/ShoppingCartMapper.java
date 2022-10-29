package springbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import springbackend.dto.ShoppingCartDto;
import springbackend.entities.ShoppingCart;

import java.math.BigDecimal;

@Mapper
public interface ShoppingCartMapper {

    @Mapping(target = "totalPrice", expression = "java(getTotalPrice(shoppingCart))")
    ShoppingCartDto toDto(ShoppingCart shoppingCart);

    default BigDecimal getTotalPrice(ShoppingCart shoppingCart){
        return shoppingCart
                .getShoppingCartFlowerArrangements()
                .stream()
                .map(fl -> fl.getFlowerArrangement().getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
