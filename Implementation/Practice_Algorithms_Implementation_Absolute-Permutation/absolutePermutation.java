import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            map.put(i, 0);
        }
        int[] original = new int[n];
        original[0] = 1;
        for (int i = 1; i < n; i++) {
            original[i] = original[i - 1] + 1;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = valueSet(original[i], k,map);
            map.put(res[i], 1);
        }
        int[] copy = res.clone();
        Arrays.sort(copy);
        if (!Arrays.equals(copy, original)) {
            int[] error = { -1 };
            return error;
        }
        return res;
    }

    static int valueSet(int a, int k, Map<Integer,Integer>map) {
        int value = 0;
        if((a-k)>0 && map.get(Math.abs(a-k))==0) {
            value = a-k;
        }else {
            value = a+k;
        }
        return value;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
