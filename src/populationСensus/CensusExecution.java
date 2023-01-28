package populationСensus;
import java.util.*;
import java.util.stream.Collectors;
import static populationСensus.Education.HIGHER;
import static populationСensus.Sex.MAN;
import static populationСensus.Sex.WOMAN;

public class CensusExecution {
  Collection<Person> persons = new ArrayList<>();
  public CensusExecution() {
    Population population = new Population();
    persons = population.getPopulationList();
  }
  public long getUnderagePeopleNumber() {
    return persons.stream()
      .filter(x -> x.getAge() < 18)
      .count();
  }
  public List<String> getMilitaryServiceLiableList() {
    return persons.stream()
      .filter(x -> x.getAge() >= 18 && x.getAge() < 27)
      .map(Person::getName)
      .collect(Collectors.toList());

  }
  public List<String> getWorkforce() {
    return persons.stream()
      .filter(x -> x.getEducation() == HIGHER)
      .filter(x -> x.getAge() >= 18)
      .filter(x -> (x.getSex() == MAN && x.getAge() < 65) || (x.getSex() == WOMAN && x.getAge() < 60))
      .map(Person::getFamily)
      .sorted(Comparator.naturalOrder())
      .collect(Collectors.toList());
  }
}
