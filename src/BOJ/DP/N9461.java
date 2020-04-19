package BOJ.DP;

import java.io.*;

// 더하는 문제는 값의 오버플로우를 잘 체크해준다.
public class N9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        while(test-- > 0){
            int N = Integer.parseInt(br.readLine());
            bw.write(P(N)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long P(int N){
        long[] n = new long[N+1];

        for(int i=1; i<=N; i++){
            if(i <= 3) {
                n[i] = 1;
            }
            else if(i > 3 && i <= 5) {
                n[i] = 2;
            }else
                n[i] = (n[i-1] + n[i-5]);
        }

        return n[N];
    }

}
