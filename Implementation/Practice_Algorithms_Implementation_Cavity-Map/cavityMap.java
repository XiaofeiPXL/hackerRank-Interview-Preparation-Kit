import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static void cavityMap(String[] grid) {
        int n = grid.length;
        int[] arr = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = Character.getNumericValue(grid[i].charAt(j));
            }
        }
        for (int i = 0; i < n * n; i++) {
            if (i % n != 0 && (i - (n - 1)) % n != 0 && i < (n * n) - n && i > n - 1) {
                int Left = arr[i - 1];
                int Right = arr[i + 1];
                int Top = arr[i - n];
                int Bottom = arr[i + n];

                if (arr[i] > Left && arr[i] > Right && arr[i] > Top && arr[i] > Bottom) {
                    System.out.print("X");
                    continue;
                }

            }
            System.out.print(arr[i]);

            if ((i - (n - 1)) % n == 0) {
                System.out.println("");
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        cavityMap(grid);

        scanner.close();
    }

}
