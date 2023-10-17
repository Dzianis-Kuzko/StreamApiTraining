package org.example;

import org.example.model.Person;
import org.example.model.Phone;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.utils.Generator.generatePeople;

public class Main {
    public static void main(String[] args) {
        List<Person> people = generatePeople(20);
//        people.forEach(System.out::println);

        // Получите список Person и отфильтруйте только те, у которых age > n и выведите в консоль.
//        printPeopleWithAgeHigherX(people, 40);

        // Получите список Person, отфильтруйте только те, у кого weight > n, преобразуйте в name и выведите в консоль.
//        printPeopleNameWithWeightHigherX(people, 95);

        // Получите список Person, отфильтруйте только те, у кого кол-во телефонов > n, преобразуйте в номера телефонов и выведите в консоль.
//        printPhoneNumbersWithMoreThanXPhones(people,4);

        // Получите список Person, преобразуйте в name и затем преобразуйте в строку, что бы имена были через запятую
//        printPeopleNamesWithComma(people);

        // Получите список Person и отсортируйте их по возрасту в порядке убывания, если возраст равен, то по именам и выведите в консоль.
//        printSortedDescPeopleByAge(people);

        //  Получите список Person и сгруппируйте их по полу.
//        printPeopleGroupedByGender(people);

        // Получите список Person и проверьте есть ли в этом списке человек, у которого номер телефона N значению.
//        printIsPersonExistWhoseNumberX(people, "+3750771863161");

        // Получите список Person, получите n по порядку человека и получите операторов его телефонов исключая дублирование.
//        printOperatorsOfNPeople(people, 10);

        // Получите список Person и получите их средний вес.
//        printAverageWeightOfPeople(people);

        // Получение список Person и найдите самого младшего по возрасту.
//        printYoungestPerson(people);
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
    }

    public static void printAverageWeightOfPeople(List<Person> people) {
        System.out.println("Получите список Person и получите их средний вес:");
        double result = people.stream()
                            .collect(Collectors.averagingDouble(Person::getWeight));
        System.out.println("Средний вес: " + result);
    }

    public static void printYoungestPerson(List<Person> people) {
        System.out.println("Получение список Person и найдите самого младшего по возрасту");
        Optional<Person> person = people.stream()
                            .min(Comparator.comparingInt(Person::getAge));

        person.ifPresent(System.out::println);
    }

}

