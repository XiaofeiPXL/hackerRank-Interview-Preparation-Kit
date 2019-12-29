import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int length = s.length();
        int count = 0;
        long total = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        if(n%length==0){
            total = (long)(count*(n/length));
        }else {
            long a = n%length;
            int part_a = 0;
            for(int i=0;i<a;i++){
                if (s.charAt(i) == 'a') {
                    part_a++;
                }
            }
            total = (long)(((n-n%length)/length)*count+part_a);
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
