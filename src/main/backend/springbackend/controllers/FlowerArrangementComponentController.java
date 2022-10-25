package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbackend.dto.FlowerArrangementComponentDto;
import springbackend.entities.FlowerArrangementComponent;
import springbackend.services.FlowerArrangementComponentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class FlowerArrangementComponentController {

    private static final String FLOWER_ARR_COMPONENTS_MAIN_URL = "/flower-arrangement-components";
    private static final String FLOWER_ARR_COMPONENTS_ID_URL = FLOWER_ARR_COMPONENTS_MAIN_URL + "/{id}";

    private static final String FLOWER_ARR_COMPONENTS_ADD_URL = FLOWER_ARR_COMPONENTS_MAIN_URL + "/{flwrArrgInfoId}" +
            "/{colorId}";
    @Autowired
    private FlowerArrangementComponentService service;

    @GetMapping(FLOWER_ARR_COMPONENTS_MAIN_URL)
    public List<FlowerArrangementComponentDto> findAll() {
        return service.findAll();
    }

    @GetMapping(FLOWER_ARR_COMPONENTS_ID_URL)
    public ResponseEntity<FlowerArrangementComponentDto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(FLOWER_ARR_COMPONENTS_ADD_URL)
    public ResponseEntity<FlowerArrangementComponentDto> add(
            @RequestBody FlowerArrangementComponent flowerArrangementComponent,
            @PathVariable Long flwrArrgInfoId,
            @PathVariable Long colorId) {
        return service.add(flowerArrangementComponent, flwrArrgInfoId, colorId);
    }
}
