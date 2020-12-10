package RE.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n13422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T; // tc
        int[] N, M; // 집의 개수, 연속된 집의 개수
        long[] K; // 최소 돈의 양
        int[][] home; // 집의 개수

        T = Integer.parseInt(br.readLine());

        N = new int[T];
        M = new int[T];
        K = new long[T];
        home = new int[T][];

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N[i] = Integer.parseInt(st.nextToken());
            M[i] = Integer.parseInt(st.nextToken());
            K[i] = Long.parseLong(st.nextToken());

            home[i] = new int[N[i]];
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N[i]; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<T; i++) {
            long sum = 0;
            int cnt = 0, first = 0;
            int end = M[i]-1;

            if(N[i] == M[i]) {
                for(int j=0; j<N[i]; j++) {
                    sum += home[i][j];
                }
                if(sum < K[i])
                    ++cnt;
            } else {
                for (int j = first; j <= end; j++) {
                    sum += home[i][j];
                }

                if (sum < K[i])
                    ++cnt;

                for (int j=0; j < N[i]-1; j++) {
                    sum -= home[i][first++];

                    if (++end >= N[i])
                        end %= N[i];

                    sum += home[i][end];

                    if (sum < K[i])
                        ++cnt;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
