package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;
import springbackend.dto.FlowerArrangementComponentDto;
import springbackend.dto.FlowerArrangementComponentGeneralInfoDto;
import springbackend.dto.FlowerArrangementDto;
import springbackend.dto.UserDto;
import springbackend.entities.FlowerArrangement;
import springbackend.entities.FlowerArrangementComponentGeneralInfo;
import springbackend.entities.User;
import springbackend.services.FlowerArrangementService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class FlowerArrangementsController {

    private static final String FLOWER_ARRANGEMENTS_MAIN_URL = "/flower-arrangements";
    private static final String FLOWER_ARRANGEMENTS_ID_URL = FLOWER_ARRANGEMENTS_MAIN_URL + "/{id}";
    @Autowired
    private FlowerArrangementService service;

    @GetMapping(FLOWER_ARRANGEMENTS_MAIN_URL)
    public List<FlowerArrangementDto> findAll() {
        return service.findAll();
    }

    @GetMapping(FLOWER_ARRANGEMENTS_ID_URL)
    public ResponseEntity<FlowerArrangementDto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(FLOWER_ARRANGEMENTS_MAIN_URL)
    public ResponseEntity<FlowerArrangementDto> add(
            @RequestBody FlowerArrangement flowerArrangement) {
        return service.add(flowerArrangement);
    }

    @PutMapping(FLOWER_ARRANGEMENTS_ID_URL)
    public ResponseEntity<FlowerArrangementDto> updateById(@PathVariable Long id, @RequestBody FlowerArrangement flowerArrangement) {
        return service.updateById(id, flowerArrangement);
    }

    @DeleteMapping(FLOWER_ARRANGEMENTS_MAIN_URL)
    public ResponseEntity<Boolean> deleteAll(){
        return service.deleteAll();
    }
}
