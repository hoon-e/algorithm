package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15655 {
    static int N;
    static int M;
    static int[] dab;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ans = new int[N];
        dab = new int[N];
        sb = new StringBuilder();

        int i=0;
        while(st.hasMoreTokens()){
            ans[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ans);
        find(ans, 0 );
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int[] ans, int num){
        if(num == M){
            for(int i=0; i<M; i++){
                sb.append(dab[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int f = 0;
        if(num != 0){
            for(int i=0; i<N; i++){
                if(ans[i] == dab[num-1]){
                    f = i+1; break;
                }
            }
        }

        for(int i=f; i<N; i++){
            dab[num] = ans[i];
            find(ans, num+1);
        }
    }
}
