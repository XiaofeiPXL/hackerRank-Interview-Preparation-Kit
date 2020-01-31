import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the shortPalindrome function below.

    public static final int CONSTANT = 1000*1000*1000+7;
    static int shortPalindrome(String s) {
        int[] freq = new int[26];
        int[][] pairFreq = new int[26][26];
        int[] tripFreq = new int[26];

        int res = 0;
        for(char c:s.toCharArray()){
           res = (res+tripFreq[c-'a'])%CONSTANT;
           for(int i=0;i<26;i++){
              tripFreq[i] = (tripFreq[i]+pairFreq[i][c-'a'])%CONSTANT;
           }

           for(int i=0;i<26;i++){
              pairFreq[i][c-'a'] = (pairFreq[i][c-'a']+freq[i])%CONSTANT;
           }

           freq[c-'a']++;
        }
        
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
