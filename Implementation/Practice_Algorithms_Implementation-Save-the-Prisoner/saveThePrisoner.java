import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
         int lastVisit = 0;
         int seat = 0;
         int lMinusN = 0;
         int rem = m%n;
         
         if(s==1) {
             if(rem==0) {
                 seat = n;
                 // reminder = 0,seat = n;
             }else {
                 seat = rem;
                 // reminder !=0,seat = rem;
             }
         }else {
             lastVisit = s-1;
             if(rem==0) {
                 seat = lastVisit;
                 // start at another point, 4,5,1,2,3,start at 4 and end 3;(s-1);
             }else {
                 int temp = lastVisit + rem;
                 if(temp<=n) {
                     seat = temp; // 4，5，1，2，3，start 4 and lastVisit = 3, rem = 2, seat =3+2=5;
                 }else {
                     lMinusN = Math.abs(lastVisit-n);//4,5,1,2,3,rem = 4, rem divide two parts, seat = rem - first part;
                     seat = rem-lMinusN;
                 }
                 
             }
         }
         return seat;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
