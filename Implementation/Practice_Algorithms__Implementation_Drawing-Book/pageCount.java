import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int res = 0;
        int count_front = 0;
        int count_back = 0;

        if (p == n || p == 1) {
            return 0;
        }

        if (p % 2 == 0) {
            count_front = p / 2;
        } else {
            count_front = (p - 1) / 2;
        }

        if (n % 2 == 0) {
            if(p%2==0){
                count_back = (n-p)/2;
            }else {
                count_back = (n-p+1)/2;
            }
        } else {
            if(p%2==0){
                count_back = (n-p-1)/2;
            }else {
                count_back = (n-p)/2;
            } 
        }

        if (count_front >= count_back) {
            res = count_back;
        } else {
            res = count_front;
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
