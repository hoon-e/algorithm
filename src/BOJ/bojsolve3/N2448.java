package BOJ.bojsolve3;

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

        printStar(0,num-1,num);

        for(int i=0; i<num; i++){
            for(int j=0; j<2*num-1; j++){
                bw.write(tile[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void printStar(int x, int y, int num){
        int half = num/2;
        if(num == 3) {
            tile[x][y] = '*';
            tile[x + 1][y - 1] = tile[x + 1][y + 1] = '*';
            tile[x + 2][y - 2] = tile[x + 2][y - 1] = tile[x + 2][y] = tile[x + 2][y + 1] = tile[x + 2][y + 2] = '*';
            return;
        }
            printStar(x,y,half);
            printStar(x+half, y-half, half);
            printStar(x+half, y+half, half);
    }
}
