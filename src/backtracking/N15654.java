package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15654 {
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
        boolean[] checked = new boolean[N];

        int i=0;
        while(st.hasMoreTokens()){
            ans[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ans);
        find(ans, checked,0 );
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int[] ans, boolean[] check, int num){
        if(num == M){
            for(int i=0; i<M; i++){
                sb.append(dab[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!check[i]){
                dab[num] = ans[i];
                check[i] = true;
                find(ans, check,num+1);
                check[i] = false;
            }
        }
    }
}
