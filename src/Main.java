import populationСensus.Education;
import populationСensus.Person;
import populationСensus.Sex;
import streamMain.StreamMain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static populationСensus.Education.HIGHER;
import static populationСensus.Sex.MAN;
import static populationСensus.Sex.WOMAN;

public class Main {
  public static List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
  public static long underagePeopleNumber;
  public static List<String> militaryServiceLiableList = new ArrayList<>();
  public static List<String> workforce = new ArrayList<>();


  public static void main(String[] args) {
    List<Integer> preparedList = filterArray(intList);

    System.out.println(preparedList);

    StreamMain streamExample = new StreamMain();
    streamExample.streamMain();

    List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
    List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
    Collection<Person> persons = new ArrayList<>();
    for (int i = 0; i < 10_000_000; i++) {
      persons.add(new Person(
        names.get(new Random().nextInt(names.size())),
        families.get(new Random().nextInt(families.size())),
        new Random().nextInt(100),
        Sex.values()[new Random().nextInt(Sex.values().length)],
        Education.values()[new Random().nextInt(Education.values().length)])
      );
    }

    Stream<Person> underagePersonStream = persons.stream();
    Stream<Person> militaryServiceLiablePersonStream = persons.stream();
    Stream<Person> workforceStream = persons.stream();

    underagePeopleNumber = underagePersonStream
      .filter(x -> x.getAge() < 18)
      .count();

    militaryServiceLiableList = militaryServiceLiablePersonStream
      .filter(x -> x.getAge() >= 18 && x.getAge() < 27)
      .map(Person::getName)
      .collect(Collectors.toList());

    workforce = workforceStream
      .filter(x -> x.getEducation() == HIGHER)
      .filter(x -> (x.getSex() == MAN && x.getAge() >= 18 && x.getAge() < 65) || (x.getSex() == WOMAN && x.getAge() >= 18 && x.getAge() < 60))
      .map(Person::getFamily)
      .sorted(Comparator.naturalOrder())
      .collect(Collectors.toList());
  }


  public static List<Integer> filterArray(List<Integer> list) {
    List<Integer> processedList = new ArrayList<>();

    for(int item : list) {
      if (item > 0 && item % 2 == 0) {
        processedList.add(item);
      }
    }
    Collections.sort(processedList);

    return processedList;
  }
}
