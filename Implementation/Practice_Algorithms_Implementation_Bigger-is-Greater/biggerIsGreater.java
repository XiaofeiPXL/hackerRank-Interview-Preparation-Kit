import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] arr = w.toCharArray();
        return reverse(arr);
        
   }
    
    public static String reverse(char[] arr) {
        boolean change = false;
        StringBuffer sb = new StringBuffer();
        int i;
        for(i=arr.length-1;i>0;i--){
            if(arr[i]>arr[i-1]){
                change = true;
                for(int j=arr.length-1;j>=i;j--) {
                    if(arr[j]>arr[i-1]) {
                         char temp = arr[j];
                         arr[j] = arr[i-1];
                         arr[i-1] = temp;
                         break;
                    }
                }
                break;
            }else {
                continue;
            }
        }
        if(!change) {
            return "no answer";
        }
        Arrays.sort(arr, i, arr.length);
        for(char x :arr) {
            sb.append(x);
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
