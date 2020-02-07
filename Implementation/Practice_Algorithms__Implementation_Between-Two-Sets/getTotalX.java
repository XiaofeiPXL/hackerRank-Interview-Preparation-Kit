import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        boolean divide = true;
        List<Integer> res = new ArrayList<Integer>();
        int[] B = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            B[i] = b.get(i);
        }
        Arrays.sort(B);

        int[] A = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            A[i] = a.get(i);
        }
        for (int x = 1; x <= B[0]; x++) {
            for (int y = 0; y < a.size(); y++) {
                if (x % A[y] != 0) {
                    divide = false;
                    break;
                }
            }
            if (divide) {
                res.add(x);
            }
            divide = true;
        }
        int[] C = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            C[i] = res.get(i);
        }
        for(int i=0;i<b.size();i++){
            for(int y=0;y<res.size();y++){
                if(B[i]%res.get(y)!=0)
                {
                    C[y]=0;
                }
            }
        }
        int count = 0;
        for(int x: C) {
            if(x!=0) {
                count++;
            }
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
