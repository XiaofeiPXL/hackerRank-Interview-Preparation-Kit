import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int n = arr.length;
         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
         for(int x:arr) {
             if(!map.containsKey(x)) {
                 map.put(x, 1);
             }else {
                 map.put(x, map.get(x)+1);
             }
         }
         int temp = Integer.MIN_VALUE;
         for(int i=0;i<n;i++) {
             if(map.get(arr[i])>temp) {
                 temp = map.get(arr[i]);
             }
         }
         
         return n-temp;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
