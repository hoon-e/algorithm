package BOJ.DP;

import java.io.*;
import java.util.*;

public class n3793 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<String> words = new ArrayList<>();

        try{
            while(true){
                String input = in.readLine();

                // EOF 조건
                if(input == null)
                    break;

                // list에 값이 들어있지않고, input이 없다면 개행이므로 다시 입력
                if(words.size() == 0 && input.length() == 0)
                    continue;

                // list에 값이 들어있고, input이 없다면
                if(words.size() != 0 && input.length() == 0)
                    break;

                st = new StringTokenizer(input);

                while(st.hasMoreTokens())
                    words.add(st.nextToken());
            }

            for(int i=0; i<words.size(); i+=2){
                String X = words.get(i);
                String Y = words.get(i+1);

                out.write(LCS(X, Y)+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        out.flush();
        in.close();
        out.close();
    }

    static int LCS(String X, String Y){
        int xLen = X.length();
        int yLen = Y.length();

        int[][] dist = new int[xLen+1][yLen+1];

        for(int i=0; i<=xLen; i++){
            for(int j=0; j<=yLen; j++){
                if(i == 0 || j == 0)
                    dist[i][j] = 0;
                else if(X.charAt(i-1) == Y.charAt(j-1))
                    dist[i][j] = dist[i-1][j-1] + 1;
                else
                    dist[i][j] = Math.max(dist[i-1][j], dist[i][j-1]);
            }
        }

        return dist[xLen][yLen];
    }
}
