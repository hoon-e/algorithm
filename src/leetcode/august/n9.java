package leetcode.august;

import java.util.*;
import java.io.*;

public class n9 {
    // rotting orange
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        boolean[][] vst = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0}); // tomato in
                    vst[i][j] = true;
                }
            }
        }

        if(isAll(grid)) {
            return 0;
        } else {
            int maxTime = -1;

            while(!q.isEmpty()) {
                int[] orange =  q.poll();

                maxTime = (maxTime < orange[2]) ? orange[2] : maxTime;

                for(int d=0; d<4; d++) {
                    int nx = orange[0] + dx[d];
                    int ny = orange[1] + dy[d];

                    if(nx < 0 || nx >= row || ny < 0 || ny >= col ) continue;
                    if(vst[nx][ny]) continue;
                    if(grid[nx][ny] == 0 || grid[nx][ny] == 2) continue;
                    grid[nx][ny] = 2;
                    vst[nx][ny] = true;
                    q.offer(new int[]{nx, ny, orange[2]+1});
                }
            }

            return maxTime = (isAll(grid)) ? maxTime : -1;
        }
    }

    public static boolean isAll(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j] == 1) return false;
        }

        return true;
    }
}
