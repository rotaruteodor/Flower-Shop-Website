package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.UserDto;
import springbackend.entities.User;

@Mapper
public interface UserMapper {
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "nrOfOrders", expression = "java(method(user))")
    UserDto toDto(User user);

//    default Integer method(User user) {
//        return 3;
//    }
}

// entity
// mapper
// Dto
// repository
// service
// manager (@Service)
// controller