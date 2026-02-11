package Activities.Activity2Feb10;

import java.util.*;

public class ArrayListAdvanced {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(12, 5, 8, 21, 7, 14, 3, 19, 2, 11)
        );

        // Remove even numbers
        list.removeIf(num -> num % 2 == 0);

        // Find min and max
        int min = Collections.min(list);
        int max = Collections.max(list);

        // Sort descending
        list.sort(Collections.reverseOrder());

        // Display results
        System.out.println("Final List: " + list);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
