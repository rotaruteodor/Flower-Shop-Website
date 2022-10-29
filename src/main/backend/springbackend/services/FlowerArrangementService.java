package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springbackend.dto.FlowerArrangementDto;
import springbackend.dto.UserDto;
import springbackend.entities.*;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.FlowerArrangementMapper;
import springbackend.repositories.ColorsRepository;
import springbackend.repositories.FlowerArrangementComponentGeneralInfoRepository;
import springbackend.repositories.FlowerArrangementComponentsRepository;
import springbackend.repositories.FlowerArrangementsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowerArrangementService {

    @Autowired
    private FlowerArrangementsRepository flowerArrangementsRepository;

    @Autowired
    private FlowerArrangementComponentGeneralInfoRepository flowerArrangementComponentGeneralInfoRepository;

    @Autowired
    private ColorsRepository colorsRepository;
    @Autowired
    private FlowerArrangementMapper mapper;

    public List<FlowerArrangementDto> findAll() {
        return flowerArrangementsRepository.findAll()
                .stream()
                .map(f -> mapper.toDto(f))
                .toList();
    }

    public ResponseEntity<FlowerArrangementDto> findById(@PathVariable Long id) {
        return flowerArrangementsRepository.findById(id)
                .map(f -> mapper.toDto(f))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("FlowerArrangement", id)));
    }

    public ResponseEntity<FlowerArrangementDto> add(@RequestBody FlowerArrangement flowerArrangement) {

        for (FlowerArrangementComponent component : flowerArrangement.getComponents()) {
            flowerArrangementComponentGeneralInfoRepository.findById(
                            component.getFlowerArrangementComponentGeneralInfo().getId())
                    .map(flArgGeneralInfo -> { // enters map only if findById returns non-null
                        component.setFlowerArrangementComponentGeneralInfo(flArgGeneralInfo);
                        return flArgGeneralInfo;
                    })
                    .orElseThrow(() -> new ResourceNotFoundException("FLOWER ARRG GEN INFO NOT FOUND"));

            colorsRepository.findById(component.getColor().getId())
                    .map(color -> {
                        component.setColor(color);
                        return color;
                    })
                    .orElseThrow(() -> new ResourceNotFoundException("COLOR NOT FOUND"));
        }

        flowerArrangementsRepository.save(flowerArrangement);
        return ResponseEntity.ok(mapper.toDto(flowerArrangement));
    }

    public ResponseEntity<FlowerArrangementDto> updateById(@PathVariable Long id,
                                                           @RequestBody FlowerArrangement flowerArrangement) {
        FlowerArrangement currentFlowerArrangement = flowerArrangementsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage
                        .getDoesNotExistErrorMessage("flowerArrangement", id)));

        for (FlowerArrangementComponent component : flowerArrangement.getComponents()) {

            flowerArrangementComponentGeneralInfoRepository.findById(
                            component.getFlowerArrangementComponentGeneralInfo().getId())
                    .map(flArgGeneralInfo -> {
                                component.setFlowerArrangementComponentGeneralInfo(flArgGeneralInfo);
                                return flArgGeneralInfo;
                            }
                    )
                    .orElseThrow(() -> new ResourceNotFoundException("FlowerArrangementComponentGeneralInfo NOT FOUND"));

            colorsRepository.findById(component.getColor().getId())
                    .map(color -> {
                        component.setColor(color);
                        return color;
                    })
                    .orElseThrow(() -> new ResourceNotFoundException("Color NOT FOUND"));
        }

        currentFlowerArrangement.setName(flowerArrangement.getName());
        currentFlowerArrangement.setPrice(flowerArrangement.getPrice());
        currentFlowerArrangement.setType(flowerArrangement.getType());
        currentFlowerArrangement.setImageUrl(flowerArrangement.getImageUrl());
        currentFlowerArrangement.setComponents(flowerArrangement.getComponents());

        FlowerArrangement updatedFlowerArrangement = flowerArrangementsRepository.save(currentFlowerArrangement);

        FlowerArrangementDto flowerArrangementDto = mapper.toDto(updatedFlowerArrangement);
        return ResponseEntity.ok(flowerArrangementDto);
    }

    public ResponseEntity<Boolean> deleteAll() {
        flowerArrangementsRepository.deleteAll();
        return ResponseEntity.ok(true);
    }
}
