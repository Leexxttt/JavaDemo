package com.lxt.chapter4;

public class Dish {
    private String name;
    private Boolean vegetarian;
    private Integer calories;
    private DishType dishType;

    public Dish(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public Dish(String name, Boolean vegetarian, Integer calories, DishType dishType) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.dishType = dishType;
    }
}
