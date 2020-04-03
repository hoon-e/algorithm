package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class N10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        int[] val = new int[10];

        int len = n.length();
        int sum = 0;
        for(int i=0; i<len; i++){
            char w = n.charAt(i);
            val[w-'0']++;
            sum += (w-'0');
        }

        if ((sum % 3 != 0) || !n.contains("0")) {
            bw.write(-1 + "\n");
        } else {
            for(int j=9; j>=0; j--){
                while(val[j] > 0){
                    bw.write(j+"");
                    val[j]--;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
