package BOJ.DP;

import java.io.*;
import java.util.*;

public class n14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(in.readLine());
        int y = Integer.parseInt(in.readLine());

        if(x > 0 && y > 0 )
            out.write(1+"\n");
        else if(x < 0 && y > 0)
            out.write(2 + "\n");
        else if(x < 0 && y < 0 )
            out.write(3+"\n");
        else
            out.write(4+"\n");

        out.flush();
        in.close();
        out.close();
    }
}
