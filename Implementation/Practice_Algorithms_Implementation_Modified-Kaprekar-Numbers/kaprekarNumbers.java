import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        int res = p;
        int count = 0;
        while (res <= q) {
            if (checkkaprekar(res))
            {
                System.out.print(res + " ");
                count++;
            }
            res++;
        }
        if(count==0) {
            System.out.println("INVALID RANGE");
        }
    }

    static boolean checkkaprekar(int a) {
        long squre = (long) Math.pow(a, 2.0);
        String str = String.valueOf(squre);
        int d = String.valueOf(a).length();
        int length = str.length();
        StringBuffer left = new StringBuffer();
        StringBuffer right = new StringBuffer();
       
        int i=0,j=length-d,count=0;
        while(count!=d && j<length) {
            right.append(str.charAt(j));
            j++;
            count++;
        }
        while(count<length) {
            left.append(str.charAt(i));
            i++;
            count++;
        }
        int m=0,n=0,res=0;
        if(left!=null && left.length()>0) {
             m = Integer.parseInt(left.toString());
        }
        if(right!=null && right.length()>0) {
             n = Integer.parseInt(right.toString());
        } 
        res = (int)(m+n);
        if (res == a) {
            return true;
        } else {
            return false;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
