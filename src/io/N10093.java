package io;

import java.io.*;
import java.util.StringTokenizer;

public class N10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long first = Long.parseLong(st.nextToken());
        long second = Long.parseLong(st.nextToken());

        if(second>first){
            bw.write((second-first-1)+"\n");
            for(long i=first+1; i<second; i++){
                bw.write(i+ " ");
            }
        }
        else if(first>second){
            bw.write((first-second-1)+"\n");
            for(long i=second+1; i<first; i++){
                bw.write(i+ " ");
            }
        }
        else if(first == second){
            bw.write(0+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
