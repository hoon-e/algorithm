package BOJ.DP;

import java.io.*;

public class N6359 {
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for(int i=0; i<test; i++){
            int testcase = Integer.parseInt(br.readLine());
            chk = new boolean[testcase+1];

            for(int j=1; j<=testcase; j++){
                for(int k=1; j*k<=testcase; k++)
                    chk[j*k] = !chk[j*k];
            }

            int cnt = 0;
            for(int j=1; j<=testcase; j++){
                if(chk[j])
                    cnt++;
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
