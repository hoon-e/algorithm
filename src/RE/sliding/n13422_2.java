package RE.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n13422_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T, N, M; // 테스트 케이스, 집의 개수, 연속된 집의 개수
        long K; // 최소 돈의 양
        int[] home; // 집의 개수

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            int cnt = 0;

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Long.parseLong(st.nextToken());

            int first = 0;
            int end = M-1;

            home = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                home[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=first; j<=end; j++) {
                sum += home[j];
            }

            if (sum < K) ++cnt;

            if(N != M) {
                for (int j=0; j<N-1; j++) {
                    sum -= home[first++];

                    if (++end >= N)
                        end %= N;

                    sum += home[end];

                    if (sum < K)
                        ++cnt;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
