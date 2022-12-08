package com.zachesov.effectivejava.chapter01.item02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Zachesov Sergei
 * @since 8/16/2022
 */
public class Pizza {
  public enum Topping {
    HAM,
    MUSHROOM,
    ONION,
    PEPPER,
    SAUSAGE
  }

  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();

    // Subclasses must override this method to return "this"
    protected abstract T self();
  }

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone(); // See Item 50
  }
}
