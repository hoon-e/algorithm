package BOJ.about_arr;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] s1 = st.nextToken().toCharArray();
            char[] s2 = st.nextToken().toCharArray();

            Arrays.sort(s1);
            Arrays.sort(s2);

            if(String.valueOf(s1).equals(String.valueOf(s2))){
                bw.write("Possible\n");
            }else
                bw.write("Impossible\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
