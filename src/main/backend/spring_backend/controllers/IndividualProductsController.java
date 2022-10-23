package spring_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_backend.entities.IndividualProduct;
import spring_backend.entities.User;
import spring_backend.exceptions.ResourceNotFoundException;
import spring_backend.repositories.IndividualProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flowershop_backend/v1")
public class IndividualProductsController {

    @Autowired
    private IndividualProductsRepository individualProductsRepository;

    @GetMapping("/individual-products")
    public List<IndividualProduct> getAll(){
        return individualProductsRepository.findAll();
    }

    @PostMapping("/add-individual-product")
    public IndividualProduct addIndividualProduct(@RequestBody IndividualProduct individualProduct) {
        return individualProductsRepository.save(individualProduct);
    }

    @GetMapping("/individual-products/{id}")
    public ResponseEntity<IndividualProduct> getProductById(@PathVariable Long id) {
        IndividualProduct product = individualProductsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: "
                        .concat(id.toString())
                        .concat(" doesn't exist")));
        return ResponseEntity.ok(product);
    }

}
