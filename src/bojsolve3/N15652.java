package bojsolve3;

// 추후에 더 풀어볼것
import java.io.*;
import java.util.StringTokenizer;

public class N15652 {
    static int N;
    static int M;
    static int[] ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        ans = new int[M];
        find(ans,0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int[] ans, int num){
        if(num == M){
            for(int i=0; i<M; i++)
                sb.append(ans[i]+1).append(" ");
            sb.append("\n");
            return;
        }
        int f=0;
        if(num != 0)
            f = ans[num-1];

        for(int i=f; i<N; i++){
            ans[num] = i;
            find(ans,num+1);
        }
    }
}
