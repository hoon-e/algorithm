package Programmers;

import java.util.*;

public class lockandkey {
    public static void main(String[] args) {
        int[][] key = {
                {0,0,0},
                {1,0,0},
                {0,1,1}};

        int[][] lock = {
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,0},
                {1,1,0,1}};

        lockandkey l = new lockandkey();
        System.out.println(l.solution(key, lock));
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int lockNum;

    public void getLockNum(int[][] lock) {
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length; j++) {
                if(lock[i][j] == 0) ++lockNum;
            }
        }
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int len = key.length;
        int locklen = lock.length;

        int[][] map = key;
        int[][] tmpKey = null;

        getLockNum(lock);

        if(lockNum != (locklen * locklen)) {
            for(int i=0; i<5; i++) {
                if (i != 0) map = rotateMap(key, len);
                key = map;

                if (isCheck(map, lock)) return true;

                for (int j = 0; j < 4; j++) { // 상, 하, 좌, 우
                    for (int k = 1; k < len; k++) { // 변의 길이만큼 민다.
                        tmpKey = pushMap(map, j, k, len);

                        if (isCheck(tmpKey, lock)) return true;

                        for (int l = 0; l < 4; l++) {
                            for (int t = 1; t < len; t++) {
                                int[][] an = pushMap(tmpKey, l, t, len);

                                if (isCheck(an, lock)) return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean isOpen(int r, int c, int[][] key, int[][] lock) {
        int openCount = 0;

        for(int a = r; a < key.length + r; a++){
            for(int b = c; b < key.length + c; b++){
                if(lock[a][b] == 0) ++openCount;
                if(key[a-r][b-c] == lock[a][b]){
                    return false;
                }
            }
        }

        return openCount == lockNum;
    }

    public boolean isCheck(int[][] key, int[][] lock) {
        int sub = lock.length-key.length+1;

        for(int r = 0; r < sub; r++){
            for(int c = 0; c < sub; c++){
                if(isOpen(r, c, key, lock)) return true;
            }
        }

        return false;
    }

    public int[][] pushMap(int[][] key, int dir, int power, int len) {
        int[][] tmpKey = new int[len][len];

        if(dir == 0) {
            for(int i=0; i<len; i++) {
                int nx = i + (dx[dir] * power);

                if (nx < 0 || nx >= len) {
                    for (int j = 0; j < len; j++) {
                        tmpKey[i][j] = 0;
                    }
                } else {
                    for (int j = 0; j < len; j++) {
                        tmpKey[nx][j] = key[i][j];
                    }
                }
            }
        } else if(dir == 1) {
            for(int i=len-1; i>=0; i--) {
                int nx = i + (dx[dir] * power);

                if (nx < 0 || nx >= len) {
                    for (int j = 0; j < len; j++) {
                        tmpKey[i][j] = 0;
                    }
                } else {
                    for (int j = 0; j < len; j++) {
                        tmpKey[nx][j] = key[i][j];
                    }
                }
            }
        } else if(dir == 2) {
            for(int i=0; i<len; i++) {
                int ny = i + (dy[dir] * power);

                if (ny < 0 || ny >= len) {
                    for (int j = 0; j < len; j++)
                        tmpKey[j][i] = 0;
                } else {
                    for (int j = 0; j < len; j++) {
                        tmpKey[j][ny] = key[j][i];
                    }
                }
            }
        } else {
            for(int i=len-1; i>=0; i--) {
                int ny = i + (dy[dir] * power);

                if (ny < 0 || ny >= len) {
                    for (int j = 0; j < len; j++)
                        tmpKey[j][i] = 0;
                } else {
                    for (int j = 0; j < len; j++) {
                        tmpKey[j][ny] = key[j][i];
                    }
                }
            }
        }


        return tmpKey;
    }

    public int[][] rotateMap(int[][] key, int len) {
        int[][] tmpKey = new int[len][len];

        for(int i=len-1; i>=0; i--) {
            for(int j=0; j<len; j++) {
                tmpKey[i][j] = key[len-j-1][i];
            }
        }

        return tmpKey;
    }
}
