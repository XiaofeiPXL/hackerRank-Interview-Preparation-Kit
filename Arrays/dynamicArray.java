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
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
        int lastAnswer = 0;
        List<List<Integer>> seqList = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            seqList.add(new ArrayList<Integer>());
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<queries.size();i++){
            List<Integer> query = new ArrayList<Integer>();
            query = queries.get(i);
            int a = query.get(0);
            if(a==1){
                int index = (query.get(1)^lastAnswer)%n;
                seqList.get(index).add(query.get(2));
            }else{
                int index = (query.get(1)^lastAnswer)%n;
                int size = seqList.get(index).size();
                int newValue = seqList.get(index).get(query.get(2)%size);
                lastAnswer = newValue;
                res.add(lastAnswer);
            }
        }
        return res;
    } 

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
