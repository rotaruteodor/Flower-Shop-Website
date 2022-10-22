package spring_backend.controllers;

import spring_backend.entities.FlowerArrangement;
import spring_backend.repositories.FlowerArrangementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/floweshop_backend/v1")
public class FlowerArrangementsController {

    @Autowired
    private FlowerArrangementsRepository flowerArrangementsRepository;

    @GetMapping("/flower-arrangements")
    public List<FlowerArrangement> getAll(){
        return flowerArrangementsRepository.findAll();
    }


}
