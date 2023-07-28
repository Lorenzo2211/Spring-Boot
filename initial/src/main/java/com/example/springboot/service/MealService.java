package com.example.springboot.service;

import com.example.springboot.model.Meal;

import java.util.ArrayList;

public class MealService {
    ArrayList<Meal> meals = new ArrayList<>();

    public MealService() {
        this.meals.add(new Meal("Fettuccine", "Fettuccine-PancettaAffumicata-Burro-Uovo-ScamorzaBianca-Pepe" , 10.00));
        this.meals.add(new Meal("Caserecce", "Caserecce-MacinatoDiSalsiccia-Pomodorini-MelanzaneFritte-Olio-Pepe-Panna",13.50));
        this.meals.add(new Meal("Orecchiette", "Orecchiette-PancettaDolce-Pomodorini-Pepe-ScaglieDiGrana-Aglio-Panna",9.90));
        this.meals.add(new Meal("Fusilli", "Fusilli-Carciofi-MacinatoDiSalsiccia-Dado-Aglio-Pepe-ProvolaDolce-CaciocavalloGrattugiato ",15.00));
    }

    public ArrayList<Meal> getAllMeals(){
        return this.meals;
    }

    public Meal getMealByName (String name){
        for(Meal meal : this.meals){
            if (meal.getName().equals(name)){
                return meal;
            }
        }
        return null;
    }

    public Meal getMealByDescription (String description){
        for(Meal meal : this.meals){
            if (meal.getDescription().equals(description)){
                return meal;
            }
        }
        return null;
    }

    public ArrayList<Meal> getMealByPrice (double max, double min) {
        ArrayList<Meal> price = new ArrayList<>();
        for (Meal meal : this.meals) {
            if (meal.getPrice() >= min && meal.getPrice() <= max) {
                price.add(meal);
            }
        }
        return price;
    }

    public void addMeal (Meal meal){
        this.meals.add(meal);
    }

    public void updateMyMeal(String name, Meal meal){
        for (int i = 0; i < this.meals.size() ; i++) {
            if (this.meals.get(i).getName().equals(name)) {
                this.meals.remove(i);
                this.meals.add(meal);
            }
        }
    }

    public void DeleteMealByName (String name){
        for(Meal meal : this.meals){
            if (meal.getName().equals(name)){
                this.meals.remove(meal);
            }
        }
    }

    public void DeleteMealByPrice (int price){
        for(Meal meal : this.meals){
            if (meal.getPrice() > price){
                this.meals.remove(meal);
            }
        }
    }

}



