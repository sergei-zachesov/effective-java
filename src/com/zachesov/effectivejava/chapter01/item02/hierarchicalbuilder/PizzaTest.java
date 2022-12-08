package com.zachesov.effectivejava.chapter01.item02.hierarchicalbuilder;

import static com.zachesov.effectivejava.chapter01.item02.hierarchicalbuilder.NyPizza.Size.SMALL;
import static com.zachesov.effectivejava.chapter01.item02.hierarchicalbuilder.Pizza.Topping.*;

// Строитель для иерархии классов
/**
 * @author Zachesov Sergei
 * @since 8/16/2022
 */
public class PizzaTest {
  public static void main(String[] args) {
    NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
    Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();

    System.out.println(pizza);
    System.out.println(calzone);
  }
}
