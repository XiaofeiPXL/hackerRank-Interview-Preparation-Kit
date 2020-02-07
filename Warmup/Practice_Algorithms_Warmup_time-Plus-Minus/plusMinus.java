import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int length = arr.length;
        double[] res = new double[3];
        int a = 0;
        int b = 0;
        int c = 0;
        for(int x:arr){
          if(x>0){
              a++;
          }
          if(x<0){
              b++;
          }
          if(x==0){
              c++;
          }
        }

        res[0] = (double)a/length;
        res[1] = (double)b/length;
        res[2] = (double)c/length;

        for(double x:res){
           System.out.printf("%.6f %n",x);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
