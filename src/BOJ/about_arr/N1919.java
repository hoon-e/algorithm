package BOJ.about_arr;

import java.io.*;

public class N1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        for(char s : s1)
            alpha1[s-'a']++;
        for(char s : s2)
            alpha2[s-'a']++;

        int count = 0;

        for(int i=0; i<26; i++){
            if(alpha1[i] != alpha2[i])
                count+= Math.abs(alpha1[i] - alpha2[i]);
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
