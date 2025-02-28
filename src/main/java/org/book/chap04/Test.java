package org.book.chap04;

import java.util.List;
import java.util.stream.Collectors;

import static org.book.chap04.Dish.menu;

public class Test {
    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish->dish.getCalories()>300)
                .map(Dish::getName)
                .limit(3)
                .toList();
        System.out.println(threeHighCaloricDishNames);

        List<String> highCaloricDishes = menu.stream()
                .filter(dish -> dish.getCalories()>300)
                .map(Dish::getName)
                .toList();
        System.out.println(highCaloricDishes);
    }
}
