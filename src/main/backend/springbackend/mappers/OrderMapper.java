package springbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import springbackend.dto.OrderDto;
import springbackend.entities.Order;

@Mapper
public interface OrderMapper {

    OrderDto toDto(Order order);
}
