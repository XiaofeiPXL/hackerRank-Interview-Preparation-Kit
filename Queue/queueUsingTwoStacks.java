import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        editor();
        
    }
    
    static void editor() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();
        String[] content;
        for(int i=0;i<N;i++) {
           content = br.readLine().split(" ");
           switch(content[0]) {
           case "1":
               Integer x  = Integer.parseInt(content[1]);
               queue.offer(x);
               break;
           case "2":
               queue.poll();
               break;
           case "3":
               int y = queue.peek();
               System.out.println(y);
           }
        }
   
        br.close();
    }
    
}


