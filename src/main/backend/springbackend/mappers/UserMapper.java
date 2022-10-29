package springbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import springbackend.dto.UserDto;
import springbackend.entities.ShoppingCart;
import springbackend.entities.User;

@Mapper
public abstract class UserMapper {

    @Autowired
    protected ShoppingCartMapper shoppingCartMapper;

    @Mapping(target = "shoppingCart", expression = "java(shoppingCartMapper.toDto(user.getShoppingCart()))")
    public abstract UserDto toDto(User user);
}

// entity
// mapper
// Dto
// repository
// service
// manager (@Service)
// controller