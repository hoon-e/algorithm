package bojsolve3;

import java.io.*;
import java.util.Arrays;

public class N2448 {
    static char[][] tile;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        tile = new char[num][2*num-1];

        for(int i=0; i<num; i++){
            Arrays.fill(tile[i], ' ');
        }
        printStar(0,0, num);

        for(int i=0; i<num; i++){
            for(int j=0; j<num-1; j++)
                bw.write(tile[i][j]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void printStar(int w, int h, int num){
        if(num == 3){
            tile[w][h] = '*';
            return;
        }
        int half = num/2;
        for(int i=0; i<half; i++){
            for(int j=0; j<2*half-1; j++){
                if((i+j) !=0 && (i+j)%2 == 0)
                    tile[i][j] = '*';

            }
        }
    }
}
