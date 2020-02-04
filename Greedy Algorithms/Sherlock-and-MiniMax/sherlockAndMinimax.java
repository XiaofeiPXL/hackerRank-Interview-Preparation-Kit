import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndMinimax function below.
    static int sherlockAndMinimax(int[] arr, int p, int q) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i+1<arr.length;i++) {
            if((arr[i]+arr[i+1])%2==0) {
                list.add((arr[i]+arr[i+1])/2);
            }else {
                list.add((arr[i]+arr[i+1])/2);
                list.add((arr[i]+arr[i+1])/2+1);
            }
        }
        list.add(p);
        list.add(q);
        Collections.sort(list);
        
        int max = 0;
        int result = 0;
        for(int x:list) {
            if(x>=p && x<=q) {
                int value = minusProcess(arr,x);
                if(value>max) {
                    max = value;
                    result = x;
                }
            }
        }
        return result;
    }

    static int minusProcess(int[] arr, int k) {
        int minValue = Integer.MAX_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            minValue = Math.min(minValue, (int) Math.abs(arr[i] - k));
        }
        return minValue;
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

        String[] pq = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pq[0]);

        int q = Integer.parseInt(pq[1]);

        int result = sherlockAndMinimax(arr, p, q);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
