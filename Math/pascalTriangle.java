package Math;

import java.util.*;

public class pascalTriangle {
    public static List<List<Integer>> allPossibleTriangle(int numberOfRows) {

        if (numberOfRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.get(0).add(1);

        for (int i = 1; i < numberOfRows; i++) {
            List<Integer> currentRows = new ArrayList<>();
            currentRows.add(1);
            // i is for each row.
            // har row meh hum (row-1)th element add kr rahe honge
            for (int j = 1; j < i; j++) {
                currentRows.add(finalList.get(i - 1).get(j) + finalList.get(i - 1).get(j - 1));
            }
            currentRows.add(1);
            finalList.add(currentRows);
        }
        return finalList;
    }

    // how can i find out nth row without using extra space.
    public static void optimized(int numberOfRows) {

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int indx = numberOfRows;
        int factorial = 1;
        for (int i = 1; i <= numberOfRows; i++) {
            factorial *= indx--;
            factorial /= i;
            ans.add(factorial);
        }
    }
}
