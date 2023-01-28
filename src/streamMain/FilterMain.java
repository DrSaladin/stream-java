package streamMain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilterMain {
  public static List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
  public static void main() {
    List<Integer> processedList = new ArrayList<>();

    for(int item : intList) {
      if (item > 0 && item % 2 == 0) {
        processedList.add(item);
      }
    }
    Collections.sort(processedList);
    System.out.println(processedList);
  }
}
