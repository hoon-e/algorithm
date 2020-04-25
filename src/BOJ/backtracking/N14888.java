package BOJ.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class N14888 {
    static int N;
    static int[] dap;
    static int[] op;
    static String ops = "+-x/";
    static long MIN = Long.MAX_VALUE;
    static long MAX = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dap = new int[N];
        op = new int[4];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            dap[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++)
            op[i] = Integer.parseInt(st.nextToken());

        find(1, dap[0]);
        bw.write(MAX + "\n" + MIN);
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int cnt, int sum){
        for(int i=0; i<4; i++){
            if(op[i] > 0){
                op[i]--;
                if(ops.charAt(i) == '+'){
                    find(cnt + 1, sum + dap[cnt]);
                }else if(ops.charAt(i) == '-'){
                    find(cnt + 1, sum - dap[cnt]);
                }else if(ops.charAt(i) == 'x'){
                    find(cnt + 1, sum * dap[cnt]);
                }else if(ops.charAt(i) == '/'){
                    find(cnt + 1, sum / dap[cnt]);
                }
                op[i]++;
            }
         }

        if(cnt == N){
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
        }
    }
}
