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

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        int temp_id = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.size();i++) {
            if(!map.containsKey(arr.get(i))) {
                map.put(arr.get(i), 1);
            }else {
                map.put(arr.get(i), map.get(arr.get(i))+1);
                
            }
        }
        int [] res = new int[6];
        res[0] = 0;
        for(int i=1;i<6;i++){
            if(map.containsKey(i)) {
                res[i] = map.get(i);
            }else {
                res[i]=0;
            }
        }
        for(int i=2;i<6;i++) {
            if(res[i]>res[temp_id])
            {
                temp_id = i;
            }
        }
        return temp_id;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
