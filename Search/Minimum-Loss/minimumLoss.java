import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
    static long minimumLoss(long[] price) {
        long minimumLoss = 0;
        Map<Long,Integer> map = new HashMap<Long,Integer>();
        List<Long> list = new ArrayList<Long>();
        for(int i=0;i<price.length;i++) {
            map.put(price[i], i);
        }
        Arrays.sort(price);
        long start = price[0];
        for(int i=1;i<price.length;i++) {
            minimumLoss = price[i]-start;
            if(map.get(price[i])<map.get(start) && minimumLoss>0) {
                list.add(minimumLoss);
            }
            start = price[i];
        }
        minimumLoss = Collections.min(list);
        return minimumLoss;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        long result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
