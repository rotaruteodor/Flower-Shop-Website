package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.OrderDto;
import springbackend.entities.Order;

@Mapper
public interface OrderMapper {
    OrderDto toDto(Order order);
}
