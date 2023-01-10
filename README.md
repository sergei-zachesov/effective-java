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
    - [2.1 Рассмотрите применение статических фабричных методов вместо конструкторов (Item 1)](#21-рассмотрите-применение-статических-фабричных-методов-вместо-конструкторов-item-1)
    - [2.2 При большом количестве параметров конструктора подумайте о проектном шаблоне Строитель (Item 2)](#22-при-большом-количестве-параметров-конструктора-подумайте-о-проектном-шаблоне-строитель-item-2)
    - [2.3 Получайте синглтон с помощью закрытого конструктора или типа перечисления (Item 3)](#23-получайте-синглтон-с-помощью-закрытого-конструктора-или-типа-перечисления-item-3)
    - [2.4 Обеспечивайте неинстанцируемость с помощью закрытого конструктора (Item 4)](#24-обеспечивайте-неинстанцируемость-с-помощью-закрытого-конструктора-item-4)
    - [2.5 Предпочитайте внедрение зависимостей жестко прошитым ресурсам (Item 5)](#25-предпочитайте-внедрение-зависимостей-жестко-прошитым-ресурсам-item-5)
    - [2.6 Избегайте создание излишних объектов (Item 6)](#26-избегайте-создание-излишних-объектов-item-6)
    - [2.7 Избегайте устаревших ссылок (Item 7)](#27-избегайте-устаревших-ссылок-item-7)
    - [2.8 Избегайте финализаторов и очистителей (Item 8)](#28-избегайте-финализаторов-и-очистителей-item-8)
    - [2.9 Предпочитайте try-with-recurse использованию try-finally (Item 9)](#29-предпочитайте-try-with-recurse-использованию-try-finally-item-9)
- [3. Методы, общие для всех объектов](#3-методы-общие-для-всех-объектов)
    - [3.1 Перекрывая equals, соблюдайте общий контракт (Item 10)](#31-перекрывая-equals-соблюдайте-общий-контракт-item-10)
    - [3.2 Всегда при перекрытии equals перекрывайте hashCode (Item 11)](#32-всегда-при-перекрытии-equals-перекрывайте-hashcode-item-11)
    - [3.3 Всегда перекрывайте toString (Item 12)](#33-всегда-перекрывайте-tostring-item-12)
    - [3.4 Перекрывайте метод clone осторожно (Item 13)](#34-перекрывайте-метод-clone-осторожно-item-13)
    - [3.5 Подумайте о реализации Comparable (Item 14)](#35-подумайте-о-реализации-comparable-item-14)
- [4 Классы и интерфейсы](#4-классы-и-интерфейсы)
    - [4.1 Минимизируйте доступность классов и интерфейсов (Item 15)](#41-минимизируйте-доступность-классов-и-интерфейсов-item-15-)
    - [4.2 Используйте в открытых классах методы доступа, а не открытые поля (Item 16)](#42-используйте-в-открытых-классах-методы-доступа-а-не-открытые-поля-item-16)
    - [4.3 Минимизируйте изменяемость (Item 17)](#43-минимизируйте-изменяемость-item-17)
    - [4.4 Предпочитайте композицию наследованию (Item 18)](#44-предпочитайте-композицию-наследованию-item-18)
    - [4.5 Проектируйте и документируйте наследование, либо запрещайте его (Item 19)](#45-предпочитайте-композицию-наследованию-item-19-)
    - [4.6 Предпочитайте интерфейсы абстрактным классам (Item 20)](#46-предпочитайте-интерфейсы-абстрактным-классам-item-20)
    - [4.7 Проектируйте интерфейсы для потомков (Item 21)](#47-проектируйте-интерфейсы-для-потомков-item-21)
    - [4.8 Используйте интерфейсы только для определения типов (Item 22)](#48-используйте-интерфейсы-только-для-определения-типов-item-22)
    - [4.9 Предпочитайте иерархии классов дескрипторам классов (Item 23)](#49-предпочитайте-иерархии-классов-дескрипторам-классов-item-23)
    - [4.10 Предпочитайте статические классы-члены нестатическим (Item 24)](#410-предпочитайте-статические-классы-члены-нестатическим-item-24)
    - [4.11 Ограничивайтесь одним классом верхнего уровня на исходный файл (Item 25)](#411-ограничивайтесь-одним-классом-верхнего-уровня-на-исходный-файл-item-25)

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
class Item3 {
    private Object readResolve() {
        // Возвращает истенный объект
        return INSTANCE;
    }
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

Это подходит для классов, который имеет только статистические методы и статистические поля (Утильные классы).

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

## 2.5 Предпочитайте внедрение зависимостей жестко прошитым ресурсам (Item 5)

Не стоит использовать класс синглтон или утильный(статистический), если они зависят от ресурсов(объектов), поведение
которых влияют на них. И не стоит предоставлять создание ресурсов этим классам.
Лучше предавать ресурсы или их фабрики для создания, конструктору (или статистической фабрике, или строителю). Этот
подход называется "Внедрение зависимостей", повышает гибкость, возможность повторного использования.

```java
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
...
}
```

## 2.6 Избегайте создание излишних объектов (Item 6)

- **Повторное использование неизменяемых объектов(пулл)**

```java
String n=new String("bikini"); // Плохо
        String p="bikini"; // Хорошо
```

При повторном использовании, в первом случае будет создаваться новый объект, во втором использоваться старый из пула.

Использование статических фабричных методов для неизменяемого объекта.

```java
Boolean.valueOf(String)
```

- **Кэширование тяжеловесных объектов**

```java
class Item6 {
    public class RomanNumerals {
        // Можно повысить производительность
        static boolean isRomanNumeralSlow(String s) {
            return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        }
    }
}
```

```java
// Оптимально
class Item6 {
    private static final Pattern ROMAN =
            Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }
}

```

- **Предпочитайте примитивы классам оберткам и следите за непреднамеренной автоматической упаковкой**

- **Не следует кэшировать легковесные объекты их уничтожит сборщик мусора**
- **Избегайте создания собственного пула объектов. За исключением для тяжеловесных объектов, например подключение к базе
  данных**

## 2.7 Избегайте устаревших ссылок (Item 7)

**Лучший способ устранить устаревшие ссылки - выход переменной, содержащей
ссылку, из области видимости.**

Источники утечки памяти:

- **Класс управляет своей памятью.** В данном случае подойдет обнуление ссылки.

```java
class Item7 {
    public pop() {
        if (size == 0) throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }
}

```

Обнуление ссылки не норма, а исключение из правил - не нужно обнулять ссылку для каждого объекта.

- **Утечка памяти в кэше.**
  Для очищения ссылок из кэша, можно использовать следующие решения.
  Использовать WeakHashMap, но только если желаемое время жизни записей кэша определяется внешним ссылками на ключ, а не
  значением.
  Можно очищать в кэше старые записи: использовать фоновые потоки(ScheduledThreadPoolExecutor), удаление старых ссылок
  после вставки новой или LinkedHashMap с методом removeEldestEntry.
- **Приложения в режиме ожидания(слушателя) и другие обратные вызовы.** Если клиенты регистрируют обратные вызовы, но
  позже не отменяют эту регистрацию, они могут накапливаться. Можно хранить на них только слабые ссылки используя
  WeakHashMap.

Утечки памяти могут накапливаться в системе годами. И обнаружить их можно тщательного ревю кода или/и с использованием
профилировщика.

## 2.8 Избегайте финализаторов и очистителей (Item 8)

- Финализаторы непредсказуемы, часто опасны и в общем случае не нужны
- Очистители (java 9+) менее опасны, чем финализаторы, но столь же непредсказуемые, медленные и, в общем случае,
  ненужные
- С помощью финализатора или очистителя нельзя выполнять никакие операции, критичные по времени
- Не обновлять состояние объекта в зависимости от финализатора или очистителя
- Серьезные проблемы производительности при использовании финализаторов или очистителей
- Финализаторы являются серьезной проблемой безопасности: они открывают ваш класс для атак финализаторов
- Генерация исключения в конструкторе должно быть достаточно для предотвращения существования объекта; однако при
  наличии финализатора это не так
- Для защиты классов, не являющихся финальными, от атак финализаторов напишите метод finalize, который не выполняет
  никаких действий
- Для класса, который инкапсулирует ресурсы, требующие освобождения, например файлы или потоки, лучше сделать его
  реализующий AutoCloseable. После этого его можно применять в конструкции try-with-recurse.

## 2.9 Предпочитайте try-with-recurse использованию try-finally (Item 9)

Предпочитайте try-with-recurse применению try-finally при работе с ресурсами, которые должны быть закрыты.
Результирующий код получается короче и понятнее, а исключения, которые он генерирует, — более полезными.

```java
class Item9 {
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new InputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}

```

Оператор try-with-recurse облегчает написание корректного кода с использованием ресурсов, которые должны быть закрыты,
что
практически невозможно с помощью try-finally.

# 3. Методы, общие для всех объектов

## 3.1 Перекрывая equals, соблюдайте общий контракт (Item 10)

Когда не следует перекрывать:

- Каждый экземпляр класса уникален по своей природе
- У класса нет необходимости в проверке "логической эквивалентности"
- Суперкласс уже переопределяет equals, и поведение суперкласса подходит для данного класса
- Класс является закрытым или закрытым на уровне пакета, и вы уверены, что его метод equals никогда не будте вызываться

Класс имеет смысл перекрывать equals, когда для него определено понятие логической эквивалентности(logical equality),
которая не совпадает с тождественностью объектов, а метод equals в суперклассе не перекрыт. Это происходит с классами
значениями(value class) - String, Integer и др.

Требования отношения эквивалентности:

- Рефлексивность: x.equals(x)==true
- Симметричность: x.equals(y)==y.equals(x)
- Транзитивность: x.equals(y)==y.equals(z)==z.equals(x)
- Непротиворечивость: x.equals(y)==x.equals(y)==x.equals(y)==...
- Отличный от null: x.equals(null)==false

Рецепт хорошего equals:

- Используйте оператор == для проверки того, что аргумент является ссылкой на данный объект
- Используйте оператор instanceof для проверки того, что аргумент имеет корректный тип
- Приводите аргумент к корректному типу
- Для каждого "важного" поля класса убедитесь, что значение этого поля в аргументе соответствует полю данного объекта

```java
class Item10 {
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        if (!(o instanceof PhoneNumber)) return false;

        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
    }
}

```

Ещё предостережения:

- Всегда перекрывайте hashCode при перекрытии equals
- Не пытайтесь быть слишком умным
- Не подставляйте другой тип вместо Object в объявлении equals

## 3.2 Всегда при перекрытии equals перекрывайте hashCode (Item 11)

**Вы обязанный перекрывать hashCode в каждом классе, перекрывающем equals.**

Контракт hashCode:

- Для одно объекта, при многократном вызове hashCode должен всегда возвращать одно и то же целое число. При условии, что
  никакая информация, используемая при сравнении этого объекта с другими методом equals, не изменилась.
- Если два объекта равны по equals, то по hashCode тоже должны быть равны
- Если два объекта неравны по equals, то по hashCode могут быть равны или не равны. Но для оптимизации, лучше что бы
  были равны

Рецепт хорошего hashCode:

1. Объявить переменную int result и инициализировать её хеш-кодом для первого значащего поля объекта, описано в п. 2, а.
2. Для остальных значащих полей:

* Вычислите хеш-код типа int следующим образом:
    * Примитивный тип: Type.hashCode(f), Type - клас обертка для примитивного типа
    * Ссылочный тип: если метод equal перекрыт и рекурсивно вызывается при использовании, то и hashCode вызывать
      рекурсивно. Если требуется сложное сравнение, то вычислить "каноническое представление" и вызвать hashCode. Если
      null, то 0.
    * Массив: вычислить для каждого объекта рекурсивно hashCode и объединить, а как в след. пункте. Если нет значащих
      элементов, то значение 0. Если все значащиеся, то Arrays.hasCode.
* Объедините хеш-код, вычисленные в предыдущем пункте: result = 31 * result + с(предыдущий hashCode).

3. Верните result

```java
class Item11 {
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}

```

И ещё:

- Не пытайтесь исключить значимые поля из вычисления хеш-кода для повышения производительности
- Не предоставляйте подробную спецификацию значения, возвращаемого hashCode, так, чтобы клиенты не могли от него
  зависеть; это позволит его изменить.

## 3.3 Всегда перекрывайте toString (Item 12)

Всегда перекрывайте метод toString в каждом инструктируемом классе, если только он не переопределен в суперклассе.

Предоставление хорошей реализации метода toString делает ваш класс гораздо более удобным в использовании, а использующею
его систему - более простой в отладке.

Чтобы представлять интерес на практике, метод toString должен возвращать всю полезную информацию, которая содержится в
объекте

Документируйте логину вывода toString, если даже не стандартизируете формат вывода.

Предоставляйте программный доступ ко всей информации в значении, возвращаемом методом toString

## 3.4 Перекрывайте метод clone осторожно (Item 13)

Класс, реализующий Cloneable, предоставляет надлежащим образом функционирующий открытый метод clone. Иначе при вызове
клон возвратится CloneNotSupportedException.

Неизменяемые классы никогда не должны предоставлять метод clone, потому что это будет просто поощрением излишнего
копирования.

Для неокончательного класса, без полей с изменяемыми объектами, необходимо перекрыть метод clone, в качестве
возвращаемого типа будет сам класс в котором он реализован. Метод clone будет вызывать super.clone.

```java
class Item13 {
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}

```

Если класс имеет поля, которые ссылаются на изменяемые объекты, то нужно вызвать clone рекурсивно для изменяемых полей.
Иначе поля клона будут ссылаться на объекты, на которые ссылаются поля объекта оригинала.

```java
class Item13 {
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

```

Архитектура Cloneable несовместима с нормальны использованием final-полей, ссылающихся на изменяемые объекты. Возможно
потребуется убрать final, что клонировать объект.

Метод clone никогда не должен вызывать перекрываемый метод для создаваемого клона.

Открытые методы clone должны опускать конструкцию throws, поскольку методы, не генерирующие проверяем исключения, более
просты в использовании.

При проектировании класса для наследования, он не должен реализовывать интерфейс Cloneable. Есть два варианта:
имитировать поведение Object, путем реализации корректного clone или как генерирующего исключение
CloneNotSupportedException.

Метод клонирования должен правильно быть синхронизирован.

Лучшие альтернативы для клонирования объектов:

1. Конструктор копирования

```java
public Yum(Yum yum);
```

2. Фабрика копий

```java
public static Yum newInstance(Yum yum);
```

Плюсы:

- Не полагается на сложный механизм создания объектов
- Не требует соблюдения слабо документированных соглашений
- Не конфликтует с использованием final-полей
- Не генерирует ненужные непроверяемые исключения
- Не требует преобразования объектов

Также данные подходы позволяют использовать для преобразования объектов

```java
new TreeMap<>(new HashMap<>());
```

## 3.5 Подумайте о реализации Comparable (Item 14)

Реализуя класс значения(value class), которое имеет упорядочение, обеспечивайте реализацию Comparable, чтобы его
экземпляры можно было легко сортировать, искать и использовать в коллекциях, основных на сравнениях.

Контракт метода compareTo:

- x.compareTo(y) == - (y.compareTo(x))
- если x.compareTo(y) > 0 && y.compareTo(z) > 0, тогда и x.compareTo(z) > 0
- если x.compareTo(y) == 0, тогда и x.compareTo(z) == y.compareTo(z)
- Рекомендуется, но не обязательно: (x.compareTo(y)==0) == (x.equals(y))

Если метод compareTo сталкивается с объектами разных типов, генерируйте исключение ClassCastException.

При сравнении значимых полей в compareTo следует избегать операторы **<** и **>**. Вместо этого использовать
статистические
методы compare классов оберток примитивных типов или методы конструирования компаратора в интерфейсе Comparator.

# 4 Классы и интерфейсы

## 4.1 Минимизируйте доступность классов и интерфейсов (Item 15)

Хорошо спроектированный модуль скрывает все детали реализации, четко отделяя API от реализации.

Делайте класс или член класса как можно более недоступным.

Классы и интерфейсы верхнего уровня могу иметь для уровня доступа: по-умолчанию и открытые.
Если класс или интерфейс верхнего уровня, доступный лишь в пределах пакета, используется только в одном классе, нужно
рассмотреть превращения его в закрытый статический класс, вложенный только в тот класс, в ктором он используется.

Если какой-либо метод перекрывает метод суперкласса, то в подклассе он не может иметь более ограниченный доступ, чем в
суперклассе.

Поля класса должны иметь уровень доступа private.
Поля константы могут быть открыты public static final. Но если константа ссылается на изменяемый объект, то поле
обладает недостатками не final поля.

Массив ненулевой длинный всегда изменяемый, ошибка если объявлен как public static final.

В Java 9+ появилось два неявных модификатора, как часть модульной системы. Открытые и защищенные члены открытых классов
в неэскортируемых пакетах дают два неявных уровня доступа, которые являются внутри модульными аналогами обычных открытых
и защищенных уровней. Данный модификаторы не так распространены и можно обойтись переупорядочиванием классов внутри
пакета.

## 4.2 Используйте в открытых классах методы доступа, а не открытые поля (Item 16)

Минусы открытых полей:

- Они лишены преимуществ инкапсуляции
- Нельзя изменить представление класса, не изменив его API
- Нельзя обеспечить выполнение инвариантов и предпринимать дополнительных действий при обращении к полю

Если класс доступен за пределами пакета, следует обеспечить методы доступа. Но если класс доступен в пределах пакета или
является закрытым вложенным классом, то никакого ущерба от предоставления доступа к его полям данных не будет.

## 4.3 Минимизируйте изменяемость (Item 17)

Неизменяемый класс - это класс, вся информация записывается в момент создания объекта и остается неизменной в течение
всего времени существования. Их проще проектировать, реализовывать и использовать. Они менее подвержены ошибкам и более
безопасны.

Как сделать класс незаменяемым:

1. Не проставлять методы, которые изменяют состояние объекта - методы установки(mutator).
2. Гарантируйте невозможность расширения класса. Добавление классу ключевого слова final, есть и другие способы.
3. Объявите все поля как final
4. Объявите все поля как private
5. Обеспечьте монопольный доступ ко всем изменяемым компонентам. Если класс имеет поля, ссылающиеся на изменяемые
   объекты, клиенты класса не должны получить ссылки на эти объекты. Не инициализируйте эти поля ссылками на объект,
   которые предоставляют клиент. Делайте защитные копии(Item) в конструктора, методах доступа и методах readObject(
   Item).

```java
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // Accessors with no corresponding mutators
    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    @Override
    public boolean equals(Object o) {
    }
}

```

Неизменяемые объекты просты. Они могут находиться только в одном состоянии - с котором был создан.

Неизменяемые объекты потокобезопасны и не нужна синхронизация.

Неизменяемые объекты можно использоваться совместно.

Можно создавать неизменяемые объекты через статическую фабрику(Item) и кешировать часто запрашиваемые объекты.

Можно совместно использовать не только неизменяемые объекты, но и их внутреннее представление.

Неизменяемые объекты образуют крупные строительные блоки для прочих объектов.

Неизменяемые объекты обеспечивают атомарность.

Основным недостатком неизменяемых классов является то, они требуют отдельных объектов для каждого уникального значения.
И следствие повышение производительности.

Запретить наследование, помимо final, можно сделать его конструктор закрытым или доступным на уровне пакета и добавить
статистическую фабрику([Item 1](#21-рассмотрите-применение-статических-фабричных-методов-вместо-конструкторов-item-1)).

```java
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}

```

Данный подход позволяет использовать несколько классов реализации, доступных в пределах пакета. За пределами пакета,
неизменяемый класс является финальным.

Если класс невозможно сделать неизменяемым, нужно максимально ограничить изменяемость и видимость.

## 4.4 Предпочитайте композицию наследованию (Item 18)

Речь идет только на наследовании от другого класса, а не реализации интерфейса.

Наследование нарушает инкапсуляцию.

- Реализация суперкласса может меняться от версии к версии, и, если это происходит,
  подкласс может перестать корректно работать, даже если его код останется нетронутым.
- В новых версиях суперкласса может появиться новый метод, который не будет учитываться в подклассах и может привести
  проблемы с безопасностью.

Композиция - вместо наследования в классе, создать в нем закрытое поле, которое будет содержать ссылку на экземпляр
существующего класса. Каждый метод экземпляра в новом классе вызывает соответсвующий метод содержащего в классе
экземпляра существующего класса, а затем возвращает полученный результат. Эта технология передачи(forwarding), а
методы - методы передачи (forwarding methods).

```java
// Wrapper class - uses composition in place of inheritance
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

// Reusable forwarding class
public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    public void clear() {
        s.clear();
    }

    public boolean contains(Object o) {
        return s.contains(o);
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public int size() {
        return s.size();
    }

    public Iterator<E> iterator() {
        return s.iterator();
    }

    public boolean add(E e) {
        return s.add(e);
    }

    public boolean remove(Object o) {
        return s.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    public Object[] toArray() {
        return s.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean equals(Object o) {
        return s.equals(o);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s.toString();
    }
}

```

У данного подхода мало недостатков, один из них SELF problem, остальные менее существенные.

Пользоваться наследованием можно, если между классом и суперклассом есть реальная связь типа и подтипа. Но даже в этом
случае применение наследование может сделать программу ненадежной, особенно если подкласс и суперкласс принадлежат к
разным пакетам, а сам суперкласс не был изначально предназначен для расширения.

## 4.5 Проектируйте и документируйте наследование, либо запрещайте его (Item 19)

Класс должен документировать, какие из методов он использует сам(self-use), которые могут быть переопределены. Для
каждого открытого или защищенного метода документация должна указывать, какие методы, которые могут быть переопределены,
он вызывает, в какой последовательности, а также каким образом результаты их вызова влияют на дальнейшую работу.

Для создания более эффективных подклассов, класс может предоставлять точки входа при внутренней обработке в виде разумно
выбранных защищенных методов.

Единственный способ протестировать класс, предназначенный для наследования - написать подклассы.
Необходимо протестировать класс путем написания подклассов до того, как он буде выпущен.

Конструкторы класса не должны вызывать методы, которые могут быть переопределены, не напрямую и не косвенно.

Если родительский класс реализовывает интерфейс Cloneable или Serializable, то ни методу clone, ни методы readObject не
разрешается вызывать методы, которые могут быть перекрыты, ни непосредственно, ни косвенно. Также эти методы должны
иметь модификатор доступа protected.

Если класс не предполагается для наследования, то лучше запретить наследование данного класса:

- Объявить как final
- Сделать все конструкторы закрытыми или доступные в пределах пакета, а вместо них использовать статистические фабрики.

## 4.6 Предпочитайте интерфейсы абстрактным классам (Item 20)

В Java разрешено только единичное наследование, это ограничение на абстрактные классы серьезно сдерживает их
использование в качестве определений типов.

Существующие классы можно легко приспособить для реализации нового интерфейса.

Интерфейсы идеально подходят для создания миксинов(класс, который может иметь дополнительное поведение).

Интерфейс позволяет создавать фреймворк неиерархического типа.

Интерфейс обеспечивают безопасное и мощное развитие функциональности с сипользованием класса-оболочки(Item)

Можно объединить преимущества интерфейсов и абстрактных классов, предоставляя абстрактный класс скелетной реализации,
сопутствующий интерфейсу.

```java
// Concrete implementation built atop skeletal implementation (Page 101)
public class IntArrays {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // The diamond operator is only legal here in Java 9 and later
        // If you're using an earlier release, specify <Integer>
        return new AbstractList<>() {
            @Override
            public Integer get(int i) {
                return a[i]; // Autoboxing (Item 6)
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val; // Auto-unboxing
                return oldVal; // Autoboxing
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}

```

Необходима документация скелетной реализации.

## 4.7 Проектируйте интерфейсы для потомков (Item 21)

В Java 8 у интерфейсов появились дефолтные методы, но добавление новых методов к существующим интерфейсам сопряжено с
риском. Которые имеют дефолтные реализации, при не во всех реализациях интерфейса может корректно работать метод.

Не всегда возможно написать дефолтный метод, который поддерживает все инварианты всех мыслимых реализаций.

В присутствии дефолтных методов существующие реализации интерфейсов могут компилироваться без ошибок или предупреждений,
но сбоить во время выполнения.

## 4.8 Используйте интерфейсы только для определения типов (Item 22)

Интерфейс следует использовать в качестве определения типа, который может быть использован для ссылки на экземпляры
класса.

Не следует использовать интерфейс констант:

```java
// Constant interface antipattern. Don't do it !
public interface PhysicalConstants {
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    static final double BOLTZMAN_CONSTANT = 1.380_648_52e-23;
}

```

Лучше использовать утильный класс констант:

```java
public class PhysicalConstants {
    private PhysicalConstants() {
    } // Prevents instantiation

    public static final double AVOGRADOS_NUMBER = 6.02214199e23;
    public static final double BOLTZAN_CONSTANT = 1.3806503e-23;
    public static final double ELECTRON_MASS = 9.10938188e-31;
}

```

## 4.9 Предпочитайте иерархии классов дескрипторам классов (Item 23)

Поле класса _дескриптор_ - указывает разновидность класса, который может находиться в разных состояниях.

Классы с дескрипторами многословны, склонны к ошибкам и неэффективны.

Применение дескрипторов является лишь бледным подобием иерархии классов. И лучше задуматься над рефакторингом.

## 4.10 Предпочитайте вложенный статический класс вложенному внутреннему классу (Item 24)

Виды классов внутри других классов(nested class) в Java:

- Вложенный статический класс(static member class)
- Вложенный внутренний класс(nonstatic member class)
- Анонимный класс(anonymous class)
- Локальный класс(local class)

Алгоритм подбора вида класса:

* Если класс внутри другого класса должен быть виден за пределами метода или он слишком длинный, для размещения в
  границах метода, используйте вложенный класс(static или nonstatic).
    * Если каждому экземпляру вложенного необходима ссылка на включающий его экземпляр, делайте его внутренним классом(
      nonstatic member class)
    * В остальных случаях статистический(static member class)
* Если класс находится внутри метода и нужно создавать экземпляр в одном месте программы и имеется тип для этого
  класса - анонимный класс(anonymous class)
* В остальных случаях локальный(local class)

## 4.11 Ограничивайтесь одним классом верхнего уровня на исходный файл (Item 25)


