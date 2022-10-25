package springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springbackend.dto.ColorDto;
import springbackend.dto.FlowerArrangementComponentGeneralInfoDto;
import springbackend.entities.Color;
import springbackend.entities.FlowerArrangementComponentGeneralInfo;
import springbackend.exceptions.ErrorMessage;
import springbackend.exceptions.ResourceNotFoundException;
import springbackend.mappers.ColorMapper;
import springbackend.repositories.ColorsRepository;

import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorsRepository repository;

    @Autowired
    private ColorMapper mapper;

    public List<ColorDto> findAll() {
        return repository.findAll()
                .stream()
                .map(color -> mapper.toDto(color))
                .toList();
    }

    public ResponseEntity<ColorDto> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(color -> mapper.toDto(color))
                .map(colorDto -> ResponseEntity.ok(colorDto))
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.getDoesNotExistErrorMessage(
                        "Color", id)));
    }

    public ResponseEntity<ColorDto> add(
            @RequestBody Color color) {
        repository.save(color);
        return ResponseEntity.ok(mapper.toDto(color));
    }
}
