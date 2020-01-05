import java.io.*;
import java.util.*;
//use BufferReader to effiency the program, use scanner will not pass all testcases due to timeout 
public class Solution {
    public static void main(String[] args) throws IOException {
        editor();
    }

    static void editor() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        Stack<String> operations = new Stack<String>();
        operations.push(str);
        int Q = Integer.parseInt(br.readLine());
        String[] content;
        for (int i = 0; i < Q; i++) {
            content = br.readLine().split(" ");
            switch (content[0]) {
            case "1":
                String W = content[1];
                str = str + W;
                operations.push(str);
                break;
            case "2":
                int m = Integer.parseInt(content[1]);
                str = str.substring(0, str.length() - m);
                operations.push(str);
                break;
            case "3":
                int n = Integer.parseInt(content[1]);
                System.out.println(str.charAt(n - 1));
                break;
            case "4":
                operations.pop();
                str = operations.peek();
            default:
                break;
            }
        }
    }
}

