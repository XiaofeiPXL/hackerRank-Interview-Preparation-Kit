import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the decentNumber function below.
        static void decentNumber(int n) {
        String a = "5";
        String b = "3";
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        if (n < 3) {
            System.out.println(-1);
        } else if (n % 3 == 0) {
            for (int x = 0; x < n; x++) {
                sb.append(a);
            }
            System.out.println(sb);
        } else if (n % 5 == 0) {
            temp = checkDivide(n);
            if (temp == -1) {
                for (int y = 0; y < n; y++) {
                    sb.append(b);
                }
                System.out.println(sb);
            } else {
                for (int x = 0; x < (n - 5 * temp); x++) {
                    sb.append(a);
                }
                for (int y = 0; y < (5 * temp); y++) {
                    sb.append(b);
                }
                System.out.println(sb);
            }

        } else {
            temp = checkDivide(n);
            if (temp == -1) {
                System.out.println(-1);
            } else {
                for (int x = 0; x < (n - 5 * temp); x++) {
                    sb.append(a);
                }
                for (int y = 0; y < (5 * temp); y++) {
                    sb.append(b);
                }
                System.out.println(sb);
            }
        }
    }

    static int checkDivide(int n) {
        int i = 1;
        while (3 * i < n) {
            if ((n - 5 * i) % 3 == 0 && (n - 5 * i) > 0) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
