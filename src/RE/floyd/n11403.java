package RE.floyd;

import java.io.*;
import java.util.*;

public class n11403 {
    static int N;
    static int[][] graph;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        graph = new int[N][N];

        for(int i=0; i<N; i++)
            Arrays.fill(graph[i], 100_000);

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(graph[i][j] == 0)
                    graph[i][j] = 100_000;
            }
        }

        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(graph[i][k] + graph[k][j] < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j] == 100_000)
                    out.write(0 + " ");
                else
                    out.write(1 + " ");
            }
            out.write("\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
