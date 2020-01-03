import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
         Stack<Integer> a = new Stack<Integer>();
         Stack<Integer> b = new Stack<Integer>();
         Stack<Integer> c = new Stack<Integer>();
         int height1 = 0;
         int height2 = 0;
         int height3 = 0;
         for(int x=h1.length-1;x>=0;x--){
           height1+=h1[x];
           a.push(h1[x]);
         }
         for(int y=h2.length-1;y>=0;y--){
           height2+=h2[y];
           b.push(h2[y]);
         }
         for(int z=h3.length-1;z>=0;z--){
           height3+=h3[z];
           c.push(h3[z]);
         }
         int minHeight = Math.min(height1,Math.min(height2,height3));
         while(height1!=height2 || height1!=height3){
              while(height1>minHeight){
                 height1-=a.pop();
              }
              minHeight = Math.min(height1,Math.min(height2,height3));
              while(height2>minHeight){
                 height2-=b.pop();
              }
              minHeight = Math.min(height1,Math.min(height2,height3));
              while(height3>minHeight){
                 height3-=c.pop();
              }
              minHeight = Math.min(height1,Math.min(height2,height3));
         }

         return minHeight;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
