package BOJ.backtracking;

import java.io.*;

public class N1339 {
    static int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static boolean[] value = new boolean[10];
    static boolean[] chk = new boolean[10];
    static int num;
    static char[][] lines;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        lines = new char[num][];

        for(int i=0; i<num; i++) {
            lines[i] = br.readLine().toCharArray();
            len += lines[i].length;
        }

        // 알파벳 있는지 여부 확인
        for(int i=0; i<num; i++){
            for(int j=0; j<lines[i].length; j++){
                chk[lines[i][j]-'A'] = true;
            }
        }

        int cnt = 0;
        int idx = 0;

        while(true){

        }
    }
}
