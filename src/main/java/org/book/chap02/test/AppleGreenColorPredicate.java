package org.book.chap02.test;

public class AppleGreenColorPredicate {
    public boolean test(Apple apple){
        return Color.GREEN.equals(apple.getColor());
    }
}
