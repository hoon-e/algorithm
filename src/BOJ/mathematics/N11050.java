package BOJ.mathematics;

import java.io.*;
import java.util.StringTokenizer;

public class N11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = 1;
        for(int i=1; i<=N; i++)
            res *= i;
        for(int i=1; i<=K; i++)
            res /= i;
        for(int i=1; i<=N-K; i++)
            res /= i;
        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
