package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springbackend.dto.FlowerArrangementComponentDto;
import springbackend.entities.FlowerArrangementComponent;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.FlowerArrangementComponentMapper;
import springbackend.repositories.ColorsRepository;
import springbackend.repositories.FlowerArrangementComponentGeneralInfoRepository;
import springbackend.repositories.FlowerArrangementComponentsRepository;

import java.util.List;

@Service
public class FlowerArrangementComponentService {

    @Autowired
    private FlowerArrangementComponentsRepository flowerArrangementComponentsRepository;

    @Autowired
    private FlowerArrangementComponentGeneralInfoRepository flowerArrangementComponentGeneralInfoRepository;

    @Autowired
    private ColorsRepository colorsRepository;

    @Autowired
    private FlowerArrangementComponentMapper mapper;

    public List<FlowerArrangementComponentDto> findAll() {
        return flowerArrangementComponentsRepository.findAll()
                .stream()
                .map(f -> mapper.toDto(f))
                .toList();
    }

    public ResponseEntity<FlowerArrangementComponentDto> findById(@PathVariable Long id) {
        return flowerArrangementComponentsRepository.findById(id)
                .map(f -> mapper.toDto(f))
                .map(fDto -> ResponseEntity.ok(fDto))
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage("FlowerArrangementComponent", id)));
    }

    public ResponseEntity<FlowerArrangementComponentDto> add(
            @RequestBody FlowerArrangementComponent flowerArrangementComponent,
            @PathVariable Long flwrArrgInfoId,
            @PathVariable Long colorId) {
        flowerArrangementComponentGeneralInfoRepository.findById(flwrArrgInfoId)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                ErrorMessage.getDoesNotExistErrorMessage(
                                        "FlowerArrangementComponentGeneralInfo", flwrArrgInfoId)));

        colorsRepository.findById(colorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorMessage.getDoesNotExistErrorMessage(
                                "Color", colorId)));

        flowerArrangementComponentsRepository.save(flowerArrangementComponent);
        return ResponseEntity.ok(mapper.toDto(flowerArrangementComponent));
    }
}
