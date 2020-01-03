import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


Scanner scan = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<Integer>();

        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            int query = scan.nextInt();
            switch (query) {
            case 1:
                int x = scan.nextInt();
                stack.push(x);
                if (maxStack.isEmpty() || x >=maxStack.peek()) {
                    maxStack.push(x);
                }
                break;
            case 2:
                int removeValue = stack.pop();
                if (removeValue == maxStack.peek()) {
                    maxStack.pop();
                }
                break;
            case 3:
                System.out.println(maxStack.peek());
                break;
            default:
                break;
            }
        }        
    }
}

