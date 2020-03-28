package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class N6603 {
    static int[] lotto;
    static int[] dab;
    static boolean[] chk;
    static int n;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            lotto = new int[n+2];
            dab = new int[n+2];
            chk = new boolean[n+2];

            if( n == 0 )
                break;

            int j=0;
            while(st.hasMoreTokens()){
                lotto[j++] = Integer.parseInt(st.nextToken());
            }
            check(0,0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void check(int st, int num){
        if( num == 6 ){
            for(int i=0; i<6; i++)
                sb.append(dab[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=st; i<n; i++){
            if(!chk[i]){
                dab[num] = lotto[i];
                chk[num] = true;
                check(i+1,num+1);
                chk[num] = false;
            }
        }
    }
}
