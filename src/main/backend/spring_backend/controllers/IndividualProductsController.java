package spring_backend.controllers;

import spring_backend.entities.IndividualProduct;
import spring_backend.repositories.IndividualProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/floweshop_backend/v1")
public class IndividualProductsController {

    @Autowired
    private IndividualProductsRepository individualProductsRepository;

    @GetMapping("/individual-products")
    public List<IndividualProduct> getAll(){
        return individualProductsRepository.findAll();
    }

}
