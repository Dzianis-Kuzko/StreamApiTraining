package org.book.chap03.test;

import org.book.chap03.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        List<Integer> listOfIntegers = new ArrayList<>();
        Predicate<String> p = (String s) -> listOfStrings.add(s);
        Consumer<String> b = (String s) -> listOfStrings.add(s);

        Apple apple = null;
        Supplier<Apple> c1 = () -> apple;
        c1 = Apple::new;

        Apple a1 = c1.get();
        TriFunction<Integer, Integer, Integer, RGB> rgbf = RGB::new;

        RGB rgb = rgbf.apply(1,2, 4);
        System.out.println(rgb);

    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
