package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
@Validated
@CrossOrigin("*")
public class FruitController {
    private final FruitService fruitService;


    @GetMapping
    public List<Fruit> findAll(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public FruitResponse get(@Positive @PathVariable Long id){
        return new FruitResponse("fruit found!", fruitService.getById(id));
    }
    @GetMapping("/desc")
    public List<Fruit> getDesc(){
        return  fruitService.getByPriceDesc();
    }
    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@Size(min = 3,max = 45, message = "name size should be between 3 and 45") @PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id){
        return fruitService.delete(id);
    }
}
