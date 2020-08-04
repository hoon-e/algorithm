package RE.string;

import java.util.*;
import java.io.*;

public class n2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int l1 = s[0].length();
        int l2 = s[1].length();
        int cr = 0, cc = 0;
        char[][] ans = new char[l2][l1];

        for(int i=0; i<l2; i++)
            Arrays.fill(ans[i], '.');

        for(int i=0; i<l1; i++){
            int idx = s[1].indexOf(s[0].charAt(i));
            if(idx != -1) {
                cr = i;
                cc = idx;
                break;
            }
        }

        for(int i=0; i<l1; i++)
            ans[cc][i] = s[0].charAt(i);
        for(int i=0; i<l2; i++)
            ans[i][cr] = s[1].charAt(i);

        for(int i=0; i<l2; i++) {
            for (int j = 0; j < l1; j++)
                bw.write(ans[i][j]);
            bw.write("\n");
        }

        bw.flush();
    }
}
