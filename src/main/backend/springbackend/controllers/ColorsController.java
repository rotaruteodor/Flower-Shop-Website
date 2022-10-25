package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbackend.dto.ColorDto;
import springbackend.dto.FlowerArrangementComponentDto;
import springbackend.entities.Color;
import springbackend.entities.FlowerArrangementComponent;
import springbackend.services.ColorService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class ColorsController {

    private static final String COLORS_MAIN_URL = "/colors";
    private static final String COLORS_ID_URL = COLORS_MAIN_URL + "/{id}";

    @Autowired
    private ColorService service;

    @GetMapping(COLORS_MAIN_URL)
    public List<ColorDto> findAll() {
        return service.findAll();
    }

    @GetMapping(COLORS_ID_URL)
    public ResponseEntity<ColorDto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(COLORS_MAIN_URL)
    public ResponseEntity<ColorDto> add(
            @RequestBody Color color) {
        return service.add(color);
    }
}
