package leetcode.july;

public class n21 {
    static boolean isAvail;
    static boolean[][] chk;
    static int strLen;
    static int R;
    static int C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 조금 더 효율적인 코드는 없을까...
    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        strLen = word.length();

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(word.charAt(0) == board[r][c]) {
                    int len = 1;
                    chk = new boolean[R][C];
                    isAvail = false;

                    dfs(r, c, len, board, word);

                    if(isAvail)
                        return true;
                }
            }
        }

        return false;
    }

    public void dfs(int r, int c, int len, char[][] board, String word) {
        if(len == word.length()) {
            isAvail = true;
            return;
        }

        chk[r][c] = true;

        for(int i=0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(chk[nx][ny]) continue;
            if(word.charAt(len) == board[nx][ny])
                dfs(nx, ny, len+1, board, word);
        }

        if(isAvail)
            return;

        chk[r][c] = false;
    }
}
