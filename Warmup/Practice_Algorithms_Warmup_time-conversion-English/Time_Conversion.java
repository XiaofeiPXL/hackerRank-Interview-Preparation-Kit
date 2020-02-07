import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        StringBuffer res = new StringBuffer("");
        String head = "";
        char[] ch = s.toCharArray();
        if(ch[8]=='P'){
           int x = ch[0]-'0';
           int y = ch[1]-'0';
           if(x==1 && y==2){
              head = "12";
           }else{
              int z = x*10+y+12;
              head = String.valueOf(z); 
           }
           res.append(head);
        }
        if(ch[8]=='A'){
           if(ch[0]=='1' && ch[1]=='2'){
             ch[0]='0';
             ch[1]='0';
           }
           res.append(ch[0]);
           res.append(ch[1]);
        }
        for(int i=2;i<8;i++){
           res.append(ch[i]);
        }
        return res.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
