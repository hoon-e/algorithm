package BOJ.string;

import java.io.*;

public class N2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        bw.write(line.length()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
