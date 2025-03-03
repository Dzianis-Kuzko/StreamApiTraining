package org.book.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Test {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)
        List<Transaction> sortedTransactionBySum = transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .toList();

        sortedTransactionBySum.forEach(System.out::println);
        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        transactions.stream()
                .map(tr-> tr.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> tradesFromCambridge = transactions.stream()
                .filter(tr-> tr.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(comparing(Trader::getName))
                .toList();
        tradesFromCambridge.forEach(System.out::println);



        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
        //порядке.
        //5. Выяснить, существует ли хоть один трейдер из Милана.
        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        //7. Какова максимальная сумма среди всех транзакций?
        //8. Найти транзакцию с минимальной суммой.

    }
}
