package RE.combination;

import java.util.*;
import java.io.*;

// 0이상 20이하이다.
public class n5557 {
    static int N, count;
    static long[][] number;
    static boolean[][] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        number = new long[N+1][21];
        chk = new boolean[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            number[0][Integer.parseInt(st.nextToken())]++;

        for(int i=1; i<=N; i++) {
            for(int j=0; j<=20; j++) {

            }
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
