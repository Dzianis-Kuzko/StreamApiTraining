package org.book.chap03;

import java.awt.*;

public class Apple {

  private int weight = 0;
  private Color color;

  public Apple(int weight, Color color) {
    this.weight = weight;
    this.color = color;
  }

  public Apple() {

  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  @SuppressWarnings("boxing")
  @Override
  public String toString() {
    return String.format("Apple{color=%s, weight=%d}", color, weight);
  }

}