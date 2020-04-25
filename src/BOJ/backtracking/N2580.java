package BOJ.backtracking;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N2580 {
    static int[][] sudoku = new int[9][9];
    static ArrayList<Point> zero = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if(sudoku[i][j] == 0)
                    zero.add(new Point(i, j));
            }
        }

        DFS(0);
    }

    static void DFS(int idx) throws IOException{
        if(idx == zero.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++)
                    bw.write(sudoku[i][j] + " ");
                bw.write("\n");
            }
            bw.flush();
            System.exit(0);
        }
        Point cur = zero.get(idx);

        for(int i=1; i<=9; i++){
            if(findCol(i, idx) && findRow(i, idx) && findBox(i, idx)){
                sudoku[cur.x][cur.y] = i;
                DFS(idx+1);
            }

            // 반복문을 벗어나게 되면 원래대로 값을 돌려놓는다.
            if(i == 9)
                sudoku[cur.x][cur.y] = 0;
        }
    }

    static boolean findBox(int num, int idx){
        Point cur = zero.get(idx);

        // (1, 3) => (1, 1)
        int nx = cur.x/3;
        int ny = cur.y/3;
        nx *= 3;
        ny *= 3;

        for(int i=nx; i<nx+3; i++){
            for(int j=ny; j<ny+3; j++){
                if(sudoku[i][j] == num) return false;
            }
        }
        return true;
    }

    static boolean findCol(int num, int idx){
        Point cur = zero.get(idx);
        for(int i=0; i<9; i++){
            if(cur.y == i) continue;
            if(sudoku[cur.x][i] == num) return false;
        }
        return true;
    }

    static boolean findRow(int num, int idx){
        Point cur = zero.get(idx);
        for(int i=0; i<9; i++){
            if(cur.x == i) continue;
            if(sudoku[i][cur.y] == num) return false;
        }
        return true;
    }
}
