package BOJ.bojsolve3;

import java.io.*;
import java.util.Arrays;

public class N2447 {
    static char[][] arr;
    static void printStar(int w, int h, int width) {
        if(width == 1){
            arr[w][h] = '*';
            return;
        }
        int half = width/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if( i== 1 && j == 1)
                    continue;
                else
                    printStar(w+(half*i), h+(half*j), half);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        arr = new char[num][num];

        for (char[] chars : arr) {
            Arrays.fill(chars, ' ');
        }

        printStar(0,0,num);

        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
