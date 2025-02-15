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

        // Получение список Person, получите их телефоны, сгруппируйте по оператору и результатом группировки должны быть только номера телефонов.
//        printNumbersGroupedByOperator(people);

        // Получение список Person, сгруппируйте их по полу и результатом группировки должно быть их кол-во.
//        printCountOfPeopleGroupedByGender(people);

        // Прочтите содержимое текстового файла и сделайте из него частотный словарик.
        // (слово -> и какое кол-во раз это слово встречается в нём)
//        printFrequencyDictionaryFromFile();

        // Получите список дат и найдите количество дней между первой и последней датой.
//        printDaysCountBetweenDates();

        // Получите список строк, преобразуйте их в числа, и посчитайте среднее значение (не забудьте отфильтровать не валидные строки)
//        printAverageNumsFromStrings();

        // Сгенерируйте миллион рандомных чисел и посчитайте их сумму используя parallelStream с двумя потоками.
//        printSumOfMillionNumbers();
    }

}

