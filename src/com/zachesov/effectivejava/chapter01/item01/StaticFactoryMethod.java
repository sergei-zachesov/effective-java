package com.zachesov.effectivejava.chapter01.item01;

import java.math.BigInteger;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;

/**
 * @author Zachesov Sergei
 * @since 8/14/2022
 */
public class StaticFactoryMethod {

  // Статичный фабричный метод

  public static void main(String[] args) {

    // +
    // 1. Имеет имена
    new BigInteger(1, 1, new Random());
    BigInteger.probablePrime(1, new Random());

    // 2. Может не создавать новый при каждом вызове
    Boolean.valueOf(true);

    // 3. Могут возвращать объект любого подтипа их возращаемого типа
    Collections.emptySortedSet();

    // 4. Класс возвращаемого объекта может быть варьироваться
    EnumSet.of(
        Test.TEST, Test.TEST, Test.TEST, Test.TEST, Test.TEST, Test.TEST, Test.TEST, Test.TEST,
        Test.TEST, Test.TEST);

    // *5. Класс возвращаемого объекта не обязан существовать во время разработки класса
    DriverManager.getDrivers();

    // -
    // 1. Классы без открытых или защищенных конструкторов не могут порождать подклассы
    Collections.emptySortedSet();

    // 2. Трудно отличить от других статистических методов

  }
}
