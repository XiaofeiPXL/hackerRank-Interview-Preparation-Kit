import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        boolean[] arr = new boolean[B.length];
        int bread = 0;
        for(int i=0;i<arr.length;i++){
            arr[i] = B[i]%2==0;
        }
        for(int i=0;i+1<arr.length;i++){
            if(!arr[i]){
                arr[i] = !arr[i];
                arr[i+1] = !arr[i+1];
                bread+=2;
            }
        }
        return arr[arr.length-1]?bread:-1;
   }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);
        bufferedWriter.write(String.valueOf(fairRations(B)==-1?"NO":result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }
}
