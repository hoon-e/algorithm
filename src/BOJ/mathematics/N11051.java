package BOJ.mathematics;

import java.io.*;
import java.util.StringTokenizer;

public class N11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1000!을 변수에 담을 수는 없다.
        // nCk = n-1Ck + n-1Ck-1 을 이용한다.

        int[][] combination = new int[1001][1001];
        int mod = 10007;

        for(int i=1; i<=1000; i++){
            combination[i][0] = combination[i][i] = 1;
            for(int j=1; j<i; j++)
                combination[i][j] = (combination[i-1][j] + combination[i-1][j-1]) % mod;
        }

        bw.write(combination[N][K]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
