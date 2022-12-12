# Краткое содержание "JAVA. Эффективное программирование", 3-е издание, Джошуа Блох

## Описание

Это мой конспект книги ["JAVA. Эффективное программирование, 3-е издание, Джошуа Блох
"](https://www.williamspublishing.com/Books/978-5-6041394-4-8.html) (сайт издательства).

[Репозиторий](https://github.com/jbloch/effective-java-3e-source-code/tree/master/src/effectivejava) с оригинальным
кодом из книги.

Если Вы автор и считаете, что данный конспект нарушает авторские права - прошу сообщить, я сделаю этот репозиторий
приватным.

# 1. Содержание

- [1. Содержание](#1-содержание)
- [2. Создание и уничтожение объектов](#2-создание-и-уничтожение-объектов)
    - [2.1 Рассмотрите применение статических фабричных методов вместо конструкторов (Item 1)](#21-рассмотрите-применение-статических-фабричных-методов-вместо-конструкторов--item-1-)
    - [2.2 При большом количестве параметров конструктора подумайте о проектном шаблоне Строитель (Item 2)](#22-при-большом-количестве-параметров-конструктора-подумайте-о-проектном-шаблоне-строитель--item-2-)

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
        //Обязательные параметры
        private final int servingSize;
        private final int servings;

        //Опциональные параметры со значением по умолчанию
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


