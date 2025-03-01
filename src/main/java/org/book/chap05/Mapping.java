package org.book.chap05;

import org.book.chap04.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.book.chap04.Dish.menu;


public class Mapping {

    public static void main(String... args) {
        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);

        List<Integer> dishNameLengths1 = menu.stream()
                .map(dish -> dish.getName().length())
                .toList();
        System.out.println(dishNameLengths1);
        // map
        List<String> words = Arrays.asList("Hello", "World");

        List<String> distinctChars = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        System.out.println(distinctChars);


        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers1.stream()
                .map(number -> number * number)
                .toList();
        System.out.println("squares: " + squares);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3);
        List<Integer> numbers3 = Arrays.asList(3, 4);

        numbers2.stream()
                .flatMap(i -> numbers3.stream()
                        .map(j -> new int[]{i, j})
                )
                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                .forEach(pair -> System.out.println(Arrays.toString(pair)));


        List<int[]> pairs5 = numbers1.stream()
                .flatMap((Integer i) -> numbers2.stream()
                        .map((Integer j) -> new int[]{i, j})
                )
                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                .collect(toList());
        pairs5.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
    }

}
