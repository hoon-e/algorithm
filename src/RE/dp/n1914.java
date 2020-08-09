package RE.dp;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class n1914 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        BigInteger count = new BigInteger("2");
        count = count.pow(K).subtract(BigInteger.ONE);

        bw.write(count + "\n");

        if(K <= 20) {
            hanoi(1, 3, K);
            bw.write(sb.toString());
        }
        bw.flush();
    }

    private static void hanoi(int a, int b, int count) {
        if(count == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        int c = 6-a-b;
        hanoi(a, c, count-1);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(c, b, count-1);
    }
}
