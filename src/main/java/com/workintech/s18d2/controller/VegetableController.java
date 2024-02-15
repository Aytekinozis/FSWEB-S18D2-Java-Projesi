package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vegetable")
@Validated
@CrossOrigin("*")
public class VegetableController {
    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> findAll(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public VegetableResponse get(@Positive @PathVariable Long id){
        return new VegetableResponse("Vegetable found!",vegetableService.getById(id));
    }

    @GetMapping("/desc")
    public List<Vegetable> getDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@Size(min = 3, max = 45, message = "name size should be between 3 and 45") @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping
    public Vegetable delete(@PathVariable Long id){
        return vegetableService.delete(id);
    }
}
