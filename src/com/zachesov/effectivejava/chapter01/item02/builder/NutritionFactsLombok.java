package com.zachesov.effectivejava.chapter01.item02.builder;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.ToString;

import java.util.Set;

// При большом количестве параметров конструктора подумайте о шаблоне Строитель
/**
 * @author Zachesov Sergei
 * @since 8/16/2022
 */
@Builder(builderMethodName = "hiddenBuilder", access = AccessLevel.PRIVATE)
@ToString
public class NutritionFactsLombok {

  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  public static NutritionFactsLombokBuilder builder(int servingSize, int servings) {
    return hiddenBuilder().servingSize(servingSize).servings(servings);
  }


  public static void main(String[] args) {
    NutritionFactsLombok cocaCola =
        NutritionFactsLombok.builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    System.out.println(cocaCola);
  }
}
