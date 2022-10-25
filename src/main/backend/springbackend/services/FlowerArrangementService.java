package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springbackend.dto.FlowerArrangementDto;
import springbackend.entities.Color;
import springbackend.entities.FlowerArrangement;
import springbackend.entities.FlowerArrangementComponent;
import springbackend.entities.FlowerArrangementComponentGeneralInfo;
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
                .map(fDto -> ResponseEntity.ok(fDto))
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("FlowerArrangement", id)));
    }

    public ResponseEntity<FlowerArrangementDto> add(
            @RequestBody FlowerArrangement flowerArrangement) {

        for (FlowerArrangementComponent component :
                flowerArrangement.getComponents()) {
            try {
                component.setFlowerArrangementComponentGeneralInfo(
                        flowerArrangementComponentGeneralInfoRepository.findById(
                                component.getFlowerArrangementComponentGeneralInfo().getId()).get());
                component.setColor(
                        colorsRepository.findById(
                                component.getColor().getId()).get());
            } catch (Exception e) {
                throw new ResourceNotFoundException(
                                "Color or flower arrangement general info doesn't exist"); //todo treat each case?
            }
        }

        flowerArrangementsRepository.save(flowerArrangement);
        return ResponseEntity.ok(mapper.toDto(flowerArrangement));
    }
}
