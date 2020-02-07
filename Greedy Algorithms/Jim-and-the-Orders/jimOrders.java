import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        int m = orders.length;
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            int sum = orders[i][0] + orders[i][1];
            map.put(i + 1, sum);
        }
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>();
        for(Map.Entry<Integer, Integer>entry:map.entrySet()) {
            list.add(entry);
        }
        
        Collections.sort(list, (p1,p2) -> (p1.getValue()).compareTo(p2.getValue()));
        
        
        
        int[] res = new int[m];
        int i=0;
        while(i<m) {
            for(Map.Entry<Integer, Integer>entry:list) {
                res[i]=entry.getKey();
                i++;
            }
        }
        
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
