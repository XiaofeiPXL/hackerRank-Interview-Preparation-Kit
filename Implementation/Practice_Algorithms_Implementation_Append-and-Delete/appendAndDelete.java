import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
         int length_s = s.length();
         int length_t = t.length();
         if(s.equals(t)){
             return (k>=(length_s*2)||k%2==0)?"Yes":"No";
         }
         
         int point = 0;
         for(int i=0;i<Math.min(length_s,length_t);i++) {
             if(s.charAt(i)!=t.charAt(i)) {
                 break;
             }else{
                 point++;
             }
         }
         
         int diff_s = s.length()-point;
         int diff_t = t.length()-point;
         if(diff_s+diff_t==k){
            return "Yes";
         }else if(s.length()+t.length()<=k){
            return "Yes";
         }else if(diff_s+diff_t<k && (diff_s+diff_t-k)%2==0){
            return "Yes";
         }else{
            return "No";
         }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
