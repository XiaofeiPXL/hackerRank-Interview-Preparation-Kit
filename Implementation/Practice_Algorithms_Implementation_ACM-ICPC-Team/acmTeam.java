import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int n = topic.length;
        int m = topic[0].length();
        int maxSkillSet = 0;
        int maxSkillTeam = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int skillSet = 0;
                String s1 = topic[i];
                String s2 = topic[j];
                for (int k = 0; k < m; k++) {
                    if (s1.charAt(k) == '1' || s2.charAt(k) == '1') {
                        skillSet++;
                    }
                }
                if (skillSet > maxSkillSet) {
                    maxSkillTeam = 1;
                    maxSkillSet = skillSet;
                } else if (skillSet == maxSkillSet) {
                    maxSkillTeam++;

                }
            }
        }
        int[] res = new int[2];
        res[0] = maxSkillSet;
        res[1] = maxSkillTeam;
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
