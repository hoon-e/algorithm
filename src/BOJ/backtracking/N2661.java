package BOJ.backtracking;

import java.io.*;
import java.util.Arrays;

public class N2661 {
    static int[] number;
    static int num;
    static StringBuffer sb = new StringBuffer();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        number = new int[num];

        minNumber(0);
    }

    static void minNumber(int len) throws IOException{
        if(len == num){
            for(int i=0; i<num; i++)
                sb.append(number[i]);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            System.exit(0);
        }

        for(int i=1; i<=3; i++){
            if(len != 0 && number[len-1] == i) continue;
            if(isContinue(len, i)) continue;
            number[len] = i;
            minNumber(len+1);
        }
    }

    static boolean isContinue(int len, int value){
        number[len] = value;

        for(int a=len; a >= len/2 + 1; a--){
            int l = len - a + 1;
            int[] src = Arrays.copyOfRange(number, a, a+l);
            int[] dst = Arrays.copyOfRange(number, a-l, a);
            if(Arrays.toString(src).equals(Arrays.toString(dst))){
                return true;
            }
        }
        return false;
    }
}
