package org.example;

import org.example.enums.Gender;
import org.example.enums.Operator;
import org.example.model.Person;
import org.example.model.Phone;

import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.utils.Generator.generatePeople;

public class Main {
    public static void main(String[] args) {
        List<Person> people = generatePeople(20);
//        people.forEach(System.out::println);

        // Получите список Person и отфильтруйте только те, у которых age > n и выведите в консоль.
        printPeopleWithAgeHigherX(people, 40);

        // Получите список Person, отфильтруйте только те, у кого weight > n, преобразуйте в name и выведите в консоль.
        printPeopleNameWithWeightHigherX(people, 95);

        // Получите список Person, отфильтруйте только те, у кого кол-во телефонов > n, преобразуйте в номера телефонов и выведите в консоль.
        printPhoneNumbersWithMoreThanXPhones(people,4);

        // Получите список Person, преобразуйте в name и затем преобразуйте в строку, что бы имена были через запятую
        printPeopleNamesWithComma(people);

        // Получите список Person и отсортируйте их по возрасту в порядке убывания, если возраст равен, то по именам и выведите в консоль.
        printSortedDescPeopleByAge(people);

        //  Получите список Person и сгруппируйте их по полу.
        printPeopleGroupedByGender(people);

        // Получите список Person и проверьте есть ли в этом списке человек, у которого номер телефона N значению.
        printIsPersonExistWhoseNumberX(people, "+3750771863161");

        // Получите список Person, получите n по порядку человека и получите операторов его телефонов исключая дублирование.
        printOperatorsOfNPeople(people, 10);

        // Получите список Person и получите их средний вес.
        printAverageWeightOfPeople(people);

        // Получение список Person и найдите самого младшего по возрасту.
        printYoungestPerson(people);

        // Получение список Person, получите их телефоны, сгруппируйте по оператору и результатом группировки должны быть только номера телефонов.
        printNumbersGroupedByOperator(people);

        // Получение список Person, сгруппируйте их по полу и результатом группировки должно быть их кол-во.
        printCountOfPeopleGroupedByGender(people);

        // Прочтите содержимое текстового файла и сделайте из него частотный словарик.
        // (слово -> и какое кол-во раз это слово встречается в нём)
        printFrequencyDictionaryFromFile();

        // Получите список дат и найдите количество дней между первой и последней датой.
        printDaysCountBetweenDates();

        // Получите список строк, преобразуйте их в числа, и посчитайте среднее значение (не забудьте отфильтровать не валидные строки)
        printAverageNumsFromStrings();

        // Сгенерируйте миллион рандомных чисел и посчитайте их сумму используя parallelStream с двумя потоками.
        printSumOfMillionNumbers();
    }

    public static void printPeopleWithAgeHigherX(List<Person> people, int x) {
        System.out.println("Список Person и отфильтруйте только те, у которых age > " + x + " и выведите в консоль:");
        people.stream()
                .filter(person -> person.getAge() > x)
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
    }

    public static void printPeopleNameWithWeightHigherX(List<Person> people, double x) {
        System.out.println("Список Person, отфильтруйте только те, у кого weight > "+ x + ", преобразуйте в name и выведите в консоль:");
        people.stream()
                .filter(person -> person.getWeight() > x)
                .map(Person::getName)
                .toList()
                .forEach(System.out::println);

        System.out.println("--------------------------------------");
    }

    public static void printPhoneNumbersWithMoreThanXPhones(List<Person> people, double x) {
        System.out.println("Список Person, отфильтруйте только те, у кого кол-во телефонов > " + x + ", преобразуйте в номера телефонов и выведите в консоль:");
        people.stream()
                .filter(person -> person.getPhones().size() > x)
                .flatMap(person -> person.getPhones().stream().map(Phone::getNumber))
                .toList()
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
    }

    public static void printPeopleNamesWithComma(List<Person> people) {
        System.out.println("Получите список Person, преобразуйте в name и затем преобразуйте в строку, что бы имена были через запятую");
        String res = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        System.out.println(res);
        System.out.println("--------------------------------------");
    }

    public static void printSortedDescPeopleByAge(List<Person> people) {
        System.out.println("Получите список Person и отсортируйте их по возрасту в порядке убывания, если возраст равен, то по именам и выведите в консоль.");
        people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed().thenComparing(Person::getName))
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
    }

    public static void printPeopleGroupedByGender(List<Person> people) {
        System.out.println("Получите список Person и сгруппируйте их по полу.");
        people.stream()
                .collect(Collectors.groupingBy(Person::getGender))
                .entrySet()
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
    }

    public static void printIsPersonExistWhoseNumberX(List<Person> people, String x) {
        System.out.println("Получите список Person и проверьте есть ли в этом списке человек, у которого номер телефона " + x + " значению.");
        // Создавал Person с определенным номером для теста
//        Person pers = new Person("d", 12, 23, Gender.MALE, List.of(new Phone(Operator.A1, "+37544333")) );
//        people.add(pers);
        boolean result = people.stream()
                            .anyMatch(person -> person.getPhones().stream()
                                    .anyMatch(phone -> phone.getNumber().equals(x)));
        System.out.println(result);
        System.out.println("\n--------------------------------------");
    }

    public static void printOperatorsOfNPeople(List<Person> people, int nPeople) {
        System.out.println("Получите список Person, получите n по порядку человека и получите операторов его телефонов исключая дублирование. ");
        people.stream()
                .limit(nPeople)
                .flatMap(person -> person.getPhones().stream().map(Phone::getOperator).distinct())
                .forEach(System.out::println);

        // Second variant

        people.forEach(person -> {
            String operators = person.getPhones().stream()
                    .map(phone -> phone.getOperator().name())
                    .distinct()
                    .collect(Collectors.joining(", "));

                     System.out.println(operators + "\n------------");
                });
        System.out.println("\n--------------------------------------");
    }

    public static void printAverageWeightOfPeople(List<Person> people) {
        System.out.println("Получите список Person и получите их средний вес:");
        double result = people.stream()
                            .collect(Collectors.averagingDouble(Person::getWeight));
        System.out.println("Средний вес: " + result);
        System.out.println("\n--------------------------------------");
    }

    public static void printYoungestPerson(List<Person> people) {
        System.out.println("Получение список Person и найдите самого младшего по возрасту");
        Optional<Person> person = people.stream()
                            .min(Comparator.comparingInt(Person::getAge));

        person.ifPresent(System.out::println);
        System.out.println("\n--------------------------------------");
    }

    // Получение список Person, получите их телефоны,
    // сгруппируйте по оператору и результатом группировки должны быть только номера телефонов.
    public static void printNumbersGroupedByOperator(List<Person> people) {
        System.out.println("Получение список Person, получите их телефоны, \nсгруппируйте по оператору и результатом группировки должны быть только номера телефонов. ");
        Map<Operator, List<String>> numbersGroupedByOperator = people.stream()
                .flatMap(person -> person.getPhones().stream())
                .collect(Collectors.groupingBy(Phone::getOperator,
                        Collectors.mapping(Phone::getNumber, Collectors.toList())));

        numbersGroupedByOperator.forEach((operator, numbers) -> {
            System.out.println("Оператор: " + operator);
            numbers.forEach(System.out::println);
        });
        System.out.println("\n--------------------------------------");
    }

    // Получение список Person, сгруппируйте их по полу и результатом группировки должно быть их кол-во.
    public static void printCountOfPeopleGroupedByGender(List<Person> people) {
        System.out.println("Получение список Person, сгруппируйте их по полу и результатом группировки должно быть их кол-во.");
        people.stream()
                .map(Person::getGender)
                .collect(Collectors.groupingBy(Enum::name))
                .forEach((s, genders) -> System.out.println(s + ": " + genders.size()) );

        System.out.println("\n--------------------------------------");
    }

    // Прочтите содержимое текстового файла и сделайте из него частотный словарик.
    // (слово -> и какое кол-во раз это слово встречается в нём)
    public static void printFrequencyDictionaryFromFile() {
        System.out.println("Прочтите содержимое текстового файла и сделайте из него частотный словарик.\n" +
                " (слово -> и какое кол-во раз это слово встречается в нём)");
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/org/example/utils/fileForDictionary"))) {

            Map<String, Integer> frequencyDictionary = new HashMap<>();

            br.lines()
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .map(word -> word.replace("[,.!?]", "").toLowerCase())
                    .forEach(word -> frequencyDictionary.put(word, frequencyDictionary.getOrDefault(word, 0) + 1));

            frequencyDictionary.forEach((word, frequency) -> {
                System.out.println(word + " -> " + frequency);
            });

            System.out.println("\n--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Получите список дат и найдите количество дней между первой и последней датой.
    public static void printDaysCountBetweenDates() {
        System.out.println("Получите список дат и найдите количество дней между первой и последней датой.");

        List<String> dateList = Arrays.asList(
                "01.01.2023", "02.01.2023", "03.01.2023", "04.01.2023", "05.01.2023",
                "06.01.2023", "07.01.2023", "08.01.2023", "09.01.2023", "10.01.2023",
                "11.01.2023", "12.01.2023", "13.01.2023", "14.01.2023", "15.01.2023",
                "16.01.2023", "17.01.2023", "18.01.2023", "19.01.2023", "20.01.2023"
        );

        long daysDifference = dateList.stream()
                .map(date -> LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .sorted()
                .max(LocalDate::compareTo)
                .map(lastDate -> dateList.stream()
                        .map(date -> LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                        .sorted()
                        .findFirst()
                        .map(firstDate -> ChronoUnit.DAYS.between(firstDate, lastDate))
                        .orElse(0L))
                .orElse(0L);

        System.out.println(daysDifference);
        System.out.println("\n--------------------------------------");
    }

    // Получите список строк, преобразуйте их в числа, и посчитайте среднее значение
    // (не забудьте отфильтровать не валидные строки)
    public static void printAverageNumsFromStrings() {
        System.out.println("Получите список строк, преобразуйте их в числа, и посчитайте среднее значение\n" +
                "(не забудьте отфильтровать не валидные строки)");
        List<String> stringList = Arrays.asList("123", "45A", "678", "9B", "10");

        double res = stringList.stream()
                .filter(s -> s.matches("-?\\d+(\\.\\d+)?"))
                .toList()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.averagingInt(Integer::shortValue));

        System.out.println(res);
        System.out.println("\n--------------------------------------");
    }

    // Сгенерируйте миллион рандомных чисел и посчитайте их сумму используя parallelStream с двумя потоками.
    public static void printSumOfMillionNumbers() {
        System.out.println("Сгенерируйте миллион рандомных чисел и посчитайте их сумму используя parallelStream с двумя потоками.");
        List<Integer> numbers = IntStream.range(0, 1000000)
                .mapToObj(i -> (int) (Math.random() * Integer.MAX_VALUE))
                .toList();

        int res = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println(res);
        System.out.println("\n--------------------------------------");
    }
}

