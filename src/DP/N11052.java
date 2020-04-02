package DP;

import java.io.*;
import java.util.StringTokenizer;

public class N11052 {
    static int[] m = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[num];
        int i=0;
        while(st.hasMoreTokens()){
            price[i++] = Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<num; j++){

        }
    }
}
