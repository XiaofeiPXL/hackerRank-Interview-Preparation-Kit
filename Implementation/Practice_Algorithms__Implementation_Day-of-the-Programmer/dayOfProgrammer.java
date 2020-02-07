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

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
       String res = "";
            int day = 0;
            String month = "";
            if(year>=1700 && year<=1917){
                if(year%4==0) {
                    day = 12;
                    month = "09";
                    res = String.valueOf(day)+"."+month+"."+String.valueOf(year);
                }else {
                    day = 13;
                    month = "09";
                    res = String.valueOf(day)+"."+month+"."+String.valueOf(year);
                }
            }
            if(year>=1919 && year<=2700){
                 if(year%400==0 ||(year%4==0 && year%100!=0)){
                     day = 12;
                     month = "09";
                     res = String.valueOf(day)+"."+month+"."+String.valueOf(year);
                }else {
                     day = 13;
                     month = "09";
                     res = String.valueOf(day)+"."+month+"."+String.valueOf(year);

                }
            }
            if(year==1918){
                 day = 26;
                 month = "09";
                 res = String.valueOf(day)+"."+month+"."+String.valueOf(year);
            }
           
            return res;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
