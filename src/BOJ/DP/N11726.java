package BOJ.DP;

import java.io.*;

public class N11726 {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        d = new int[1001];

        d[1] = 1;
        d[2] = 2;

        if(n < 3){
            bw.write(n + "\n");
            bw.flush();
            return;
        }else{
            for(int i=3; i<=n; i++){
                d[i] = (d[i-1] + d[i-2])%10007;
            }
            bw.write(d[n]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
