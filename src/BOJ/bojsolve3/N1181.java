package BOJ.bojsolve3;

import java.io.*;
import java.util.*;

public class N1181 {
    static class word{
        Set<String> wordlist;
        word(){
            wordlist = new TreeSet<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());
        String[] line = new String[num];
        int maxlength=Integer.MIN_VALUE;

        for(int i=0; i<num; i++){
            line[i] = br.readLine();
            int length = line[i].length();
            maxlength = Math.max(maxlength, length);
        }

        word[] w = new word[maxlength+1];

        for(int i=0; i<num; i++){
            int len = line[i].length();

            if(w[len] == null) {
                w[len] = new word();
                w[len].wordlist.add(line[i]);
            }else
                w[len].wordlist.add(line[i]);
        }

        for(int i=1; i<=maxlength; i++){
            if(w[i] == null)
                continue;
            for(String sw : w[i].wordlist){
                sb.append(sw).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
