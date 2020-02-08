import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for(int m=0;m<j-i+1;i++){
            int reverse = reverse(i+m);
            if(Math.abs(i-reverse)%k==0){
               count++;
            }
        }
        return count;
    }

    static int reverse(int n){
        int rev = 0;
        while(n!=0){
           int temp = n%10;
           n = n/10;
           if(rev>Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10){
               return 0;
           }
           rev = rev*10 + temp;
        }
        return rev;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
