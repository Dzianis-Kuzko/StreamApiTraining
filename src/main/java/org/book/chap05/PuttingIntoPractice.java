package org.book.chap05;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PuttingIntoPractice {

  public static void main(String... args) {
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

    // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
    List<Transaction> tr2011 = transactions.stream()
        .filter(transaction -> transaction.getYear() == 2011)
        .sorted(comparing(Transaction::getValue))
        .collect(toList());
    System.out.println(tr2011);

    // Query 2: What are all the unique cities where the traders work?
    List<String> cities = transactions.stream()
        .map(transaction -> transaction.getTrader().getCity())
        .distinct()
        .collect(toList());
    System.out.println(cities);

    // Query 3: Find all traders from Cambridge and sort them by name.
    List<Trader> traders = transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> trader.getCity().equals("Cambridge"))
        .distinct()
        .sorted(comparing(Trader::getName))
        .collect(toList());
    System.out.println(traders);

    // Query 4: Return a string of all traders' names sorted alphabetically.
    String traderStr = transactions.stream()
        .map(transaction -> transaction.getTrader().getName())
        .distinct()
        .sorted()
        .reduce("", (n1, n2) -> n1 + n2);
    System.out.println(traderStr);

    // Query 5: Are there any trader based in Milan?
    boolean milanBased = transactions.stream()
        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    System.out.println(milanBased);

    // Query 6: Print all transactions' values from the traders living in Cambridge.
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(Transaction::getValue)
        .forEach(System.out::println);

    // Query 7: What's the highest value in all the transactions?
    int highestValue = transactions.stream()
        .map(Transaction::getValue)
        .reduce(0, Integer::max);
    System.out.println(highestValue);

    // Find the transaction with the smallest value
    Optional<Transaction> smallestTransaction = transactions.stream()
        .min(comparing(Transaction::getValue));
    // Here I cheat a bit by converting the found Transaction (if any) to a String
    // so that I can use a default String if no transactions are found (i.e. the Stream is empty).
    System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
  }

}
