package org.book.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {

    public static void main(String... args) {
        // Simple example
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        // Filtering with lambdas
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples = filter(inventory, (Apple a) -> a.getColor() == Color.GREEN);
        System.out.println(greenApples);

        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();

        // [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120}, Apple{color=GREEN, weight=155}]
        inventory.sort(c);
        System.out.println(inventory);

        Object o = (Runnable) () -> {
            System.out.println("Tricky example");
        };

        Predicate<Apple> redApple = (Apple a) -> a.getColor() == Color.RED;

        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);

        Predicate<Apple> redAndHeavyApple1 = (apple) -> (apple.getColor() == Color.RED) && (apple.getWeight() > 150);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Function<Integer, Integer> h = f.compose(g);

        System.out.println(h.apply(1));


        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transFormationPipeline = addHeader.andThen(Letter::addFooter);


    }


    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {

        boolean test(Apple a);

    }

}
