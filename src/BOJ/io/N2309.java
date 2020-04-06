package BOJ.io;

import java.io.*;
import java.util.Arrays;

public class N2309 {
    static int[] dab;
    static boolean[] chk;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];
        dab = new int[7];
        chk = new boolean[9];
        sb = new StringBuffer();

        for(int i=0; i<9; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        findDwarf(num, 0);
    }

    static void findDwarf(int[] num, int n){
        if( n == 7 ){
            int sum=0;
            for(int i=0; i<7; i++){
                sum += dab[i];
            }

            if(sum == 100){
                Arrays.sort(dab);
                for(int i=0; i<7; i++){
                    sb.append(dab[i]).append("\n");
                }
                System.out.print(sb.toString());
                System.exit(0);
            }
            return;
        }

        for(int i=0; i<9; i++){
            if(!chk[i]){
                dab[n] = num[i];
                chk[i] = true;
                findDwarf(num, n+1);
                chk[i] = false;
            }
        }
    }
}
