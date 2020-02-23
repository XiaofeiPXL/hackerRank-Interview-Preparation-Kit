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

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
        // Write your code here
        int  length = c.size();
        long[][] arr = new long[51][251];
        Arrays.fill(arr[0], 0);
        arr[0][0] = 1; 
        
        for(int i=1;i<=length;i++) {
            for(int j=0;j<=n;j++) {
                arr[i][j]=0;
                for(int k=0;k*c.get(i-1)<=j;k++) {
                    arr[i][j] += arr[i-1][(int) (j-k*c.get(i-1))];
                }
                /*
                   line 33-36 can change to:
                   arr[i][j] = arr[i-1][j] + 
                   (c.get(i-1)<=j?arr[i][(int) (j-c.get(i-1))]:0);
                */
                
                /*
                optimize the space complexity:
                public static long getWays(int n, List<Long> c) 
                {
		        // Write your code here
                int  length = c.size();
                long[] arr = new long[251];
                Arrays.fill(arr, 0);
                arr[0] =1;
        
                for(int i=1;i<=length;i++) 
                {
        	       for(int j=0;j<=n;j++) 
                   {
        		       if(j>=c.get(i-1)) 
                       {
        			     arr[j] +=arr[(int) (j-c.get(i-1))];
        		       }  
        	       }
                }
                    return arr[n];
	            }
                */
            }
        }
        return arr[length][n];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
