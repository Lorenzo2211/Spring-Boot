package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import com.example.springboot.service.StudentiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealController {

    private MealService mealService = new MealService();
    @GetMapping("/meal")
    public ResponseEntity<ArrayList<Meal>> getMeal(){
        return ResponseEntity.ok(this.mealService.getAllMeals());
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<?> getMealByName(@PathVariable("name")String name){
        if(this.mealService.getMealByName(name) == null){
            return ResponseEntity.badRequest().body("Pasto non presente");
        }
        return ResponseEntity.ok(this.mealService.getMealByName(name));
    }

    @GetMapping("/meal/description-match/{description}")
    public ResponseEntity<?> getMealByDescription(@PathVariable("description")String description){
        if(this.mealService.getMealByDescription(description) == null){
            return ResponseEntity.badRequest().body("Pasto non presente");
        }
        return ResponseEntity.ok(this.mealService.getMealByDescription(description));
    }

    @GetMapping("/meal/price")
    public ResponseEntity<?> getMealByPriceRange(
            @RequestParam("min") double min,
            @RequestParam("max") double max) {
        if(this.mealService.getMealByPrice(max, min) == null){
            return ResponseEntity.badRequest().body("Pasto non presente");
        }
        return ResponseEntity.ok(this.mealService.getMealByPrice(max, min));
    }
}
