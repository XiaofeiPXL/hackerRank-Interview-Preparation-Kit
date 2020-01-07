import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        int[] res = new int[number.length];
        int count=0;
        Stack<Integer> original = new Stack<Integer>();
        for (int x : number) {
            original.push(x);
        }
        int primeFirst = 2;
        for (int i = 0; i < q; i++) {
            Stack<Integer> B = new Stack<Integer>();
            Stack<Integer> nextA = new Stack<Integer>();
            while (!original.isEmpty()) {
                int item = original.pop();
                if (item % primeFirst == 0) {
                    B.push(item);
                } else {
                    nextA.push(item);
                }
            }

            while (!B.isEmpty()) {
                int temp = B.pop();
                res[count]=temp;
                count++;
                //System.out.println(B.pop());
            }
            original = nextA;
            primeFirst = nextPrime(primeFirst);
        }
        while (!original.isEmpty()) {
            int temp = original.pop();
            res[count] =temp;
            count++;
            //System.out.println(original.pop());
        }
        return res; 
    }

    static int nextPrime(int next) {
        for (int i = next + 1;; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    static boolean isPrime(int a) {
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
