# Краткое содержание "JAVA. Эффективное программирование", 3-е издание, Джошуа Блох

## Описание

Это мой конспект
книги ["JAVA. Эффективное программирование", 3-е издание, Джошуа Блох](https://www.williamspublishing.com/Books/978-5-6041394-4-8.html) (
сайт издательства).

[Репозиторий](https://github.com/jbloch/effective-java-3e-source-code/tree/master/src/effectivejava) с оригинальным
кодом из книги.

Если Вы автор и считаете, что данный конспект нарушает авторские права - прошу сообщить, я сделаю этот репозиторий
приватным.

# 1. Содержание

- [1. Содержание](#1-содержание)
- [2. Создание и уничтожение объектов](#2-создание-и-уничтожение-объектов)
    - [2.1 Рассмотрите применение статических фабричных методов вместо конструкторов (Item 1)](#21-рассмотрите-применение-статических-фабричных-методов-вместо-конструкторов--item-1-)
    - [2.2 При большом количестве параметров конструктора подумайте о проектном шаблоне Строитель (Item 2)](#22-при-большом-количестве-параметров-конструктора-подумайте-о-проектном-шаблоне-строитель--item-2-)
    - [2.3 Получайте синглтон с помощью закрытого конструктора или типа перечисления (Item 3)](#23-получайте-синглтон-с-помощью-закрытого-конструктора-или-типа-перечисления--item-3-)
    - [2.4 Обеспечивайте неинстанцируемость с помощью закрытого конструктора (Item 4)](#24-обеспечивайте-неинстанцируемость-с-помощью-закрытого-конструктора--item-4-)

# 2. Создание и уничтожение объектов

## 2.1 Рассмотрите применение статических фабричных методов вместо конструкторов (Item 1)

Плюсы:

- Они имеют имена
- Они не обязаны создавать новые объекты при каждом вызове
- Могу возвращать объект любого подтипа их возвращаемого типа
- Класс возращенного объекта может варьироваться от вызова к вызову в зависимости от входных параметров
- Класс возвращаемого объекта не обязан существовать во время разработки класса, содержащего метод.

Минусы:

- Классы без открытых или защищенных конструкторов не могу порождать подклассы
- Трудно отличить от других статических методов

## 2.2 При большом количестве параметров конструктора подумайте о проектном шаблоне Строитель (Item 2)

- Если конструктор или статические фабрики имеет большое количество параметров(4+), то лучше рассмотреть шаблон
  Строитель при создании объекта.
- Код клиента проще для чтения и записи
- Безопаснее чем шаблон JavaBeans и может быть неизменяемым

_Реализация_:

```java

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Обязательные параметры
        private final int servingSize;
        private final int servings;

        // Опциональные параметры со значением по умолчанию
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
```

_Код клиента:_

```java

NutritionFacts cocaCola=new NutritionFacts.Builder(240,8).calories(100).sodium(35).carbohydrate(27).build();

```

## 2.3 Получайте синглтон с помощью закрытого конструктора или типа перечисления (Item 3)

_Синглтон с полем public final:_

```java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { ...}

    public void singASong() { ...}
}

```

Плюсы:

- Из-за public поля API делает очевидным, что объект будет синглтом
- Простая реализация

_Синглтон со статической фабрикой:_

```java
    public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {...}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void singASong() {...}
}

```

Плюсы:

- Можно изменить класс на не синглтон, не меняя его API
- Можно написать обобщенную фабрику синглтонов
- Можно использовать ссылку на метод, при использовании лямбды-выражения

Минусы этих реализаций:

- Можно вызвать конструктор с помощью рефлексии. Защита - добавить в конструктор генерацию исключения, при
  создании второго экземпляра.

Что бы сделать эти классы сериализуемым, необходимо пометить все поля transient и предоставить метод readResolve.

```java

private Object readResolve(){
        // Возвращает истенный объект
        return INSTANCE;
        }
```

_Синглтон-перечисление:_

```java

public enum Elvis() {
    INSTANCE;
		...

    public void singASong() {...}
}

```

Самый компактный способ, но не поддерживается наследование, только реализация интерфейса.

## 2.4 Обеспечивайте неинстанцируемость с помощью закрытого конструктора (Item 4)

Это подходит для классов, который имеет только статистические методы и статистические поля(Утильные классы).

Например:

- Группировка связанных методов над примитивами или массивами(java.util.Arrays)
- Группировка статистических методов и фабрики(java.util.Collections)
- Группировка методов в final-классе

```java
public class UtilityClass {
  private UtilityClass() {
    throw new AssertionError();
  }
}

```
