package about_arr;

import java.io.*;

public class N10808 {
    static int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        for(int i=0; i<line.length(); i++){
            alphabet[line.charAt(i)-97]++;
        }

        for(int s: alphabet)
            bw.write(s + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
