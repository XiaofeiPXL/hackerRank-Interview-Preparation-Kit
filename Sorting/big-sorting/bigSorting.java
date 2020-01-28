import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                
                return stringCompare(o1,o2);
            }

        });
        return unsorted;
    }

    public static int stringCompare(String a, String b) {
        if (a.length() < b.length()) {
            return -1;
        } else if (a.length() > b.length()) {
            return 1;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) < b.charAt(i)) {
                    return -1;
                } else if (a.charAt(i) > b.charAt(i)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

         int n = Integer.parseInt(reader.readLine());

         String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
          String unsortedItem = reader.readLine();
          unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        reader.close();
    }
}
