import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static long mergeSort(int[] arr, int L, int R) {
        long count = 0;
        // if only one element, return
        if (L == R) {
            return 0;
        } else {

            // choose the middle element
            int M = (L + R) / 2;

            // sorting left part
            count = mergeSort(arr, L, M);

            // sorting right part
            count +=mergeSort(arr, M + 1, R);

            // merge
            count +=merge(arr, L, M + 1, R);

        }
        return count;
    }

    public static long merge(int[] arr, int L, int M, int R) {
        long count =0;
        // size of left part array
        int[] leftArray = new int[M - L];

        // size of right part array
        int[] rightArray = new int[R - M + 1];

        // push elements into these two parts
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arr[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arr[i];
        }

        int i = 0, j = 0;
        // first element of the final array
        int k = L;

        // compare the elements of these two parts, which one is smaller, add it into
        // final array
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                count+=M-L-i;
            }
        }

        // if one part is all compared, add all of the rest elements into final array
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
