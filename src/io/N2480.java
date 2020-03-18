package io;

import java.io.*;
import java.util.StringTokenizer;

public class N2480 {
    static int[] dice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dice = new int[7];
        int[] num = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=0;
        int sum=0;
        while(st.hasMoreTokens()){
            num[i++] = Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<3; j++){
            dice[num[j]]++;
        }

        if(dice[num[0]] == 1 && dice[num[1]] == 1 && dice[num[2]] == 1)
            sum = 100*Math.max(num[0], Math.max(num[1], num[2]));
        else{
            for(int j=0; j<3; j++){
                if(dice[num[j]] == 2){
                    sum = 1000 + num[j]*100;
                    break;
                }else if(dice[num[j]] == 3){
                    sum = 10000 + num[j]*1000;
                    break;
                }
            }
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
