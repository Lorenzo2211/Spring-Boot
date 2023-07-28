package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SecondMealController {

    private MealService mealService = new MealService();

    @GetMapping("/meal")
    public ResponseEntity<ArrayList<Meal>> getMeal(){
        return ResponseEntity.ok(this.mealService.getAllMeals());
    }

    @PostMapping("/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
        if (meal != null) {
            this.mealService.addMeal(meal);
            return ResponseEntity.ok("Meal Added!");
        }
        return ResponseEntity.badRequest().body("No meal to add");
    }

    @PutMapping("/meal/{name}")
    public ResponseEntity<String> updateMeal(@PathVariable("name")String name, @RequestBody Meal meal){
        if(name == null || meal == null){
            return ResponseEntity.badRequest().body("Impossible Update");
        }
        this.mealService.updateMyMeal(name, meal);
        return ResponseEntity.ok("Meal Updated!");
    }

    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable("name")String name){
        if(name == null){
            return ResponseEntity.badRequest().body("Impossibile to delete");
        }
        this.mealService.DeleteMealByName(name);
        return ResponseEntity.ok("Meal Removed");
    }

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<?> deleteMealByPrice(@PathVariable ("price") int price){
        if (price <= 0){
            return ResponseEntity.badRequest().body("Impossible to delete");
        }
        this.mealService.DeleteMealByPrice(price);
        return ResponseEntity.ok(this.mealService.getAllMeals());
    }

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updateMealPrice(@PathVariable("name")String name, @RequestBody Meal meal){
        if(name == null || meal == null){
            return ResponseEntity.badRequest().body("Impossible Update");
        }
        this.mealService.updateMyMeal(name, meal);
        return ResponseEntity.ok("Meal Updated!");
    }

}
