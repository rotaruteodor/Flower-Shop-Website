package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springbackend.dto.FlowerArrangementComponentGeneralInfoDto;
import springbackend.dto.UserDto;
import springbackend.entities.FlowerArrangementComponentGeneralInfo;
import springbackend.entities.User;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.FlowerArrangementComponentGeneralInfoMapper;
import springbackend.repositories.FlowerArrangementComponentGeneralInfoRepository;

import java.util.List;

@Service
public class FlowerArrangementComponentGeneralInfoService {

    @Autowired
    private FlowerArrangementComponentGeneralInfoRepository repository;

    @Autowired
    private FlowerArrangementComponentGeneralInfoMapper mapper;

    public List<FlowerArrangementComponentGeneralInfoDto> findAll() {
        return repository.findAll()
                .stream()
                .map(f -> mapper.toDto(f))
                .toList();
    }

    public ResponseEntity<FlowerArrangementComponentGeneralInfoDto> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(f -> mapper.toDto(f))
                .map(fDto -> ResponseEntity.ok(fDto))
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.getDoesNotExistErrorMessage("FlowerArrangementComponentGeneralInfo", id)));
    }

    public ResponseEntity<FlowerArrangementComponentGeneralInfoDto> add(
            @RequestBody FlowerArrangementComponentGeneralInfo flowerArrangementComponentGeneralInfo) {
        repository.save(flowerArrangementComponentGeneralInfo);
        return ResponseEntity.ok(mapper.toDto(flowerArrangementComponentGeneralInfo));
    }

}
