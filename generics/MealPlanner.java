package com.bridgelabz.generics;



import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generated Meal Plan:");
        for (T m : meal.getMeals()) {
            System.out.println(m);
        }
    }
}

public class MealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        Meal<VeganMeal> veganMeals = new Meal<>();
        Meal<KetoMeal> ketoMeals = new Meal<>();
        Meal<HighProteinMeal> highProteinMeals = new Meal<>();

        vegetarianMeals.addMeal(new VegetarianMeal("Vegetable Stir Fry"));
        vegetarianMeals.addMeal(new VegetarianMeal("Paneer Salad"));

        veganMeals.addMeal(new VeganMeal("Vegan Smoothie"));
        veganMeals.addMeal(new VeganMeal("Tofu Scramble"));

        ketoMeals.addMeal(new KetoMeal("Avocado Chicken Salad"));
        ketoMeals.addMeal(new KetoMeal("Keto Egg Muffins"));

        highProteinMeals.addMeal(new HighProteinMeal("Grilled Chicken Breast"));
        highProteinMeals.addMeal(new HighProteinMeal("Salmon Steak"));

        System.out.println("Vegetarian Meal Plan:");
        MealPlanGenerator.generateMealPlan(vegetarianMeals);

        System.out.println("\nVegan Meal Plan:");
        MealPlanGenerator.generateMealPlan(veganMeals);

        System.out.println("\nKeto Meal Plan:");
        MealPlanGenerator.generateMealPlan(ketoMeals);

        System.out.println("\nHigh Protein Meal Plan:");
        MealPlanGenerator.generateMealPlan(highProteinMeals);
    }
}
