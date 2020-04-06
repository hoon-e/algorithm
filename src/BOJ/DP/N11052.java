package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] m = new int[num + 1];
        int[] n = new int[num + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 1;
        while (st.hasMoreTokens()) {
            m[i++] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j <= num; j++) {
            for (int k = 1; k <= j; k++) {
                n[j] = Math.max(n[j], (n[j - k] + m[k]));
            }
        }

        bw.write(n[num] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
