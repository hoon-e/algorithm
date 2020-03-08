package bojsolve3;

import java.io.*;

public class N1992 {
    static char[][] quad;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        quad = new char[num][num];
        sb = new StringBuffer();

        for(int i=0; i<num; i++){
            quad[i] = br.readLine().toCharArray();
        }

        find_quad(0, 0, num);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isOne(int s, int e, int width){
        int one = 0;
        int zero = 0;
        if (width != 1) {
            for (int i = s; i < s + width; i++) {
                for (int j = e; j < width + e; j++) {
                    if(quad[i][j] == '1')
                        one++;
                    else
                        zero++;

                    if(one > 0 && zero > 0)
                        return false;
                }
            }
        }
        sb.append(quad[s][e]);
        return true;
    }

    static void find_quad(int s, int e, int width){
        if(isOne(s,e,width)){
            return;
        }
        else{
            sb.append('(');
            find_quad(s, e, width/2);
            find_quad(s, e+width/2, width/2);
            find_quad(s+width/2, e, width/2);
            find_quad(s+width/2, e+width/2, width/2);
            sb.append(')');
        }
    }
}
