import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        Map<Integer,Integer> unSort_map = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++) {
            unSort_map.put(arr[i], i);
        }
        
        Map<Integer,Integer> unSort_map_reverse = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++) {
            unSort_map_reverse.put(arr[i], i);
        }
        int[] Arr = Arrays.copyOf(arr, arr.length);
        return Math.min(process(unSort_map,arr),process_reverse(unSort_map_reverse,Arr));
    }
    
    static int process(Map<Integer, Integer> map,int[] arr) {
        int res = 0;
        int[] ARR = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ARR);
        Map<Integer,Integer> Sort_map = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++) {
            Sort_map.put(ARR[i], i);
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!= ARR[i]) {
                int index = (int)map.get(ARR[i]);
                swap(arr,i,(int)map.get(ARR[i]));
                res++;
                map.put(arr[i], i);
                map.put(arr[index], index);
            }
        }
        return res;        
    }
    
    static int process_reverse(Map<Integer, Integer> map,int[] arr) {
        int res = 0;
        int[] ARR = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ARR);
        int[] array = new int[ARR.length];
        for(int i=0;i<arr.length;i++) {
            array[i] = ARR[arr.length-i-1];
        }
        Map<Integer,Integer> Sort_map = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++) {
            Sort_map.put(array[i], i);
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!= array[i]) {
                int index = (int)map.get(array[i]);
                swap(arr,i,(int)map.get(array[i]));
                res++;
                map.put(arr[i], i);
                map.put(arr[index], index);
            }
        }
        return res;        
    }
    
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
