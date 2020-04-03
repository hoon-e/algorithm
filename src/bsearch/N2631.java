package bsearch;

import java.io.*;
import java.util.Arrays;

public class N2631 {
    static int[] child = new int[201];
    static int[] chk = new int[201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++)
            child[i] = Integer.parseInt(br.readLine());

        chk[0] = child[0];
        int size = 1;

        for(int i=1; i<num ;i++){
            if(child[i] < chk[0]) {
                chk[0] = child[i];
            }
            else if(child[i] > chk[size-1]){
                chk[size] = child[i];
                size++;
            }else{
                int idx = Arrays.binarySearch(chk, 0, size, child[i]);
                if( idx < 0 ) idx = -idx-1;
                chk[idx] = child[i];
            }
        }

        bw.write((num-size)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
