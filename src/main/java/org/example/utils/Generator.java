package org.example.utils;

import org.example.enums.Gender;
import org.example.enums.Operator;
import org.example.model.Person;
import org.example.model.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static List<Person> generatePeople(int count) {
        List<Person> people = new ArrayList<>();
        String[] names = {"Влад", "Наталья", "Ольга", "Владимир", "Олег", "Денис", "Максим", "Настя", "Лера", "Соня", "Даник", "Дима", "Аня", "Катя", "Антон", "Витя", "Виталик", "Даша", "Коля"};

        for (int i = 0; i < count; i++) {
            String name = names[new Random().nextInt(names.length)];
            int age = getRandomAge(18, 70);
            double weight = getRandomWeight(30.0, 100.0);
            Gender gender = getRandomGender();
            List<Phone> phones = generatePhones(new Random().nextInt(5) + 1);

            Person person = new Person(name, age, weight, gender, phones);
            people.add(person);
        }

        return people;
    }

    public static int getRandomAge(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static double getRandomWeight(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    public static Gender getRandomGender() {
        Random random = new Random();
        int index = random.nextInt(Gender.values().length);
        return Gender.values()[index];
    }

    public static List<Phone> generatePhones(int count) {
        List<Phone> phones = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Operator operator = getRandomOperator();
            String number = generateRandomPhoneNumber();
            Phone phone = new Phone(operator, number);
            phones.add(phone);
        }

        return phones;
    }

    public static Operator getRandomOperator() {
        Random random = new Random();
        int index = random.nextInt(Operator.values().length);
        return Operator.values()[index];
    }

    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder("+375");

        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
