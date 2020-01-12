import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
         int total = 0;
        for (int i = 0; i < contests.length; i++) {
            total += contests[i][0];
        }

        List<Integer> important = new ArrayList<Integer>();
        int scores_important = 0;
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                important.add(contests[i][0]);
                scores_important += contests[i][0];
            }
        }
        Collections.sort(important);
        int scores = 0;
        if (important.size() >= k) {
            for (int i = important.size() - k; i < important.size(); i++) {
                scores += important.get(i);
            }
        } else {
            return total;
        }

        int diff = scores_important - scores;

        return total - 2 * diff;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
