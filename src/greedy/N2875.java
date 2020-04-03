package greedy;

import java.io.*;
import java.util.StringTokenizer;

public class N2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int team = 0;

        while ((I <= (N - 2) + (K - 1)) && (N >= 2 && K >= 1)) {
            N -= 2;
            K -= 1;
            team++;
        }

        bw.write(team+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
