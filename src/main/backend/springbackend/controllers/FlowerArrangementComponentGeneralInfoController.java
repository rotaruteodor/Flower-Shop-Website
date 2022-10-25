package springbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbackend.dto.FlowerArrangementComponentGeneralInfoDto;
import springbackend.entities.FlowerArrangementComponentGeneralInfo;
import springbackend.services.FlowerArrangementComponentGeneralInfoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop-backend")
public class FlowerArrangementComponentGeneralInfoController {

    private static final String FLOWER_ARR_COMP_GENERAL_INFO_MAIN_URL = "/flower-arrangement-components-general-info";
    private static final String FLOWER_ARR_COMP_GENERAL_INFO_ID_URL = FLOWER_ARR_COMP_GENERAL_INFO_MAIN_URL + "/{id}";

    @Autowired
    private FlowerArrangementComponentGeneralInfoService service;

    @GetMapping(FLOWER_ARR_COMP_GENERAL_INFO_MAIN_URL)
    public List<FlowerArrangementComponentGeneralInfoDto> findAll() {
        return service.findAll();
    }

    @GetMapping(FLOWER_ARR_COMP_GENERAL_INFO_ID_URL)
    public ResponseEntity<FlowerArrangementComponentGeneralInfoDto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(FLOWER_ARR_COMP_GENERAL_INFO_MAIN_URL)
    public ResponseEntity<FlowerArrangementComponentGeneralInfoDto> add(
            @RequestBody FlowerArrangementComponentGeneralInfo flowerArrangementComponentGeneralInfo) {
        return service.add(flowerArrangementComponentGeneralInfo);
    }
}

