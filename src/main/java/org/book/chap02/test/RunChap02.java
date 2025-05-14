package org.book.chap02.test;


import java.util.ArrayList;
import java.util.List;

public class RunChap02 {
    public static void main(String[] args) {

    }
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
