package BOJ.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class N15649 {
    static int N;
    static int M;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuffer();
        boolean[] used = new boolean[N];
        int[] ans = new int[M];
        find(ans, used, 0);
        // 어떤 수가 수열에 이미 쓰였는가
        // 어떤 수가 아직 쓰이지 않았는가
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int[] ans, boolean[] used, int num){
        if(num == M){
            for(int i=0; i<M; i++)
                sb.append((ans[i]+1)).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!used[i]){
                ans[num] = i;
                used[i] = true;
                find(ans, used, num+1);
                used[i] = false;
            }
        }
    }
}
