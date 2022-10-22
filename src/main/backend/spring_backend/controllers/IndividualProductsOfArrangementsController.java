package spring_backend.controllers;

import spring_backend.entities.IndividualProductOfArrangement;
import spring_backend.repositories.IndividualProductsOfArrangementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop_backend/v1")
public class IndividualProductsOfArrangementsController {

    @Autowired
    private IndividualProductsOfArrangementsRepository individualProductsOfArrangementsRepository;

    @GetMapping("/products-of-arrangements")
    public List<IndividualProductOfArrangement> getAll(){
        return individualProductsOfArrangementsRepository.findAll();
    }

}
