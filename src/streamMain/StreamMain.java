package streamMain;
import java.util.*;

public class StreamMain {
  public static List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
  public static void main() {
    intList.stream()
      .filter(x -> x > 0)
      .filter(x -> x % 2 == 0)
      .sorted(Comparator.naturalOrder())
      .forEach(System.out::println);
  }
}
