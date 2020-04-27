package BOJ.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class N1427 {
    static char[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        word = br.readLine().toCharArray();
        Arrays.sort(word);

        for(int i=word.length-1; i>=0; i--)
            bw.write(word[i]);

        bw.flush();
        bw.close();
        br.close();
    }
}
