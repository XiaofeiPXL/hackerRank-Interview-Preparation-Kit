import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] arr = new char[m][n];
        int count = 0;
        while (count < m) {
            for (int i = 0; i < m; i++) {
                arr[i] = grid[i].toCharArray();
                Arrays.sort(arr[i]);
            }
            count++;
        }

        if (checkSorted(arr,m,n)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    static boolean checkSorted(char[][] arr,int m,int n) {
        for (int i = 0; i < n; i++) {
            for (int y = 1; y < m; y++) {
                if (arr[y][i] < arr[y - 1][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
