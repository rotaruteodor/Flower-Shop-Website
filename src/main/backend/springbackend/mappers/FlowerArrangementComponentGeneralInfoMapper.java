package springbackend.mappers;

import org.mapstruct.Mapper;
import springbackend.dto.FlowerArrangementComponentGeneralInfoDto;
import springbackend.entities.FlowerArrangementComponentGeneralInfo;

@Mapper
public interface FlowerArrangementComponentGeneralInfoMapper {

    FlowerArrangementComponentGeneralInfoDto toDto
            (FlowerArrangementComponentGeneralInfo flowerArrangementComponentGeneralInfo);
}
