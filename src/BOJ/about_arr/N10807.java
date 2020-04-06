package BOJ.about_arr;

import java.io.*;
import java.util.StringTokenizer;

public class N10807 {
    static int[] find = new int[201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            find[num+100]++;
        }
        bw.write(find[Integer.parseInt(br.readLine())+100]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
