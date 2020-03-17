package bojsolve3;

import java.io.*;

public class N11726 {
    static boolean[][] tilemap;
    static int count;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tilemap = new boolean[4][n+2];

        find_tile(0, 0);
        bw.write((count%10007)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check(){
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                if(!tilemap[i][j])
                    return false;
            }
        }
        return true;
    }

    static void find_tile(int x, int y){
        if(check()){
            count++;
            return;
        }
        if(x < 0 || x >= 2 || y < 0 || y >= n)
            return;
        if(tilemap[x][y] && (tilemap[x][y+1]) || (tilemap[x+1][y]))
            return;
        tilemap[x][y] = true;
        find_tile(x, y+1);
        find_tile(x+1, y);
        tilemap[x][y] = false;
    }
}
