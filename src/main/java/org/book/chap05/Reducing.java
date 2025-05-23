package org.book.chap05;

import org.book.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.book.chap04.Dish.menu;


public class Reducing {

    public static void main(String... args) {


        Integer countDish = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println(countDish);

        Integer countDish1 = (int) menu.stream()
                .count();
        System.out.println(countDish1);


        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }

}
