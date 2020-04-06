package BOJ.bojsolve3;

import java.io.*;

public class N1159 {
    static int[] first = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());
        int count=0;
        for(int i=0; i<num; i++){
            String name = br.readLine();
            first[name.charAt(0)-97]++;
        }

        for(int i=0; i<26; i++){
            if(first[i] >= 5){
                sb.append((char)(i+97));
                count++;
            }
        }

        if(count == 0)
            bw.write("PREDAJA");
        else
            bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
