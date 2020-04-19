package BOJ.bruteforce;

import java.io.*;

public class N4690 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=2; i<=100; i++){
            int start = (int)Math.pow(i, 3);

            for(int j=2; j<=100; j++){
                if(start - (int)Math.pow(j,3) <= 0) break;
                start -= (int)Math.pow(j, 3);

                for(int k=j+1; k<=100; k++){
                    if(start - (int)Math.pow(k,3) <= 0) break;
                    start -= (int)Math.pow(k, 3);

                    for(int l=k+1; l<=100; l++){
                        if(start - (int)Math.pow(l,3) < 0) break;
                        start -= (int)Math.pow(l, 3);

                        if(start != 0) {
                            start += (int)Math.pow(l,3);
                            continue;
                        }
                        bw.write("Cube = " + i + ", Triple = (" + j + "," + k + "," + l + ")\n");
                        start += (int)Math.pow(l,3);
                        break;
                    }
                    start += (int)Math.pow(k,3);
                }
                start += (int)Math.pow(j,3);
            }
        }
        bw.flush();
    }
}
