package bojsolve3;

import java.io.*;

public class N1100 {
    static char[][] chess = new char[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 8; i++)
            chess[i] = br.readLine().toCharArray();

        int ex = 0;

        int flag = 0;
        for (int i = 0; i < 8; i++) {
            if(i%2 == 0)
                flag = 0;
            else
                flag = 1;

            for (int j = flag; j < 8; j += 2) {
                if (chess[i][j] == 'F')
                    ex++;
            }
        }

        bw.write(ex+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
