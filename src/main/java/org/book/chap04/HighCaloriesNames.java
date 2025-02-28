package org.book.chap04;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.book.chap04.Dish.menu;

public class HighCaloriesNames {

  public static void main(String[] args) {
    List<String> names = menu.stream()
        .filter(dish -> {
          System.out.println("filtering " + dish.getName());
          System.out.println(dish.getCalories() > 300);
          return dish.getCalories() > 300;
        })
        .map(dish -> {
          System.out.println("mapping " + dish.getName());
          return dish.getName();
        })
        .limit(3)
        .collect(toList());
    System.out.println(names);
  }

}
