package spring_backend.controllers;

import org.springframework.web.bind.annotation.*;
import spring_backend.entities.Color;
import spring_backend.entities.IndividualProduct;
import spring_backend.entities.IndividualProductOfArrangement;
import spring_backend.repositories.IndividualProductsOfArrangementsRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    @PostMapping("/add-individual-product-of-arrangement")
    public IndividualProductOfArrangement addProductOfArrangement
            (@RequestBody IndividualProductOfArrangement product) {
        return individualProductsOfArrangementsRepository.save(product);
    }

//    @PostMapping("/add-individual-product-of-arrangement/{individualProductId}/{colorId}")
//    public IndividualProductOfArrangement addProductOfArrangement
//            (@RequestBody IndividualProductOfArrangement productOfArrangement,
//             @PathVariable Long individualProductId,
//             @PathVariable Long colorId) {
//        IndividualProduct product =
//                Color color =
//                productOfArrangement.setIndividualProduct(product);
//        productOfArrangement.setColor(color);
//        return individualProductsOfArrangementsRepository.save(productOfArrangement);
//    }


}
