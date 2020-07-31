package BOJ.DP;


import java.io.*;
import java.util.*;

public class n2565 {
    static class elec {
        int start;
        int end;

        elec(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(in.readLine());
        elec[] elecs = new elec[num];

        for(int i=0; i<num; i++){
            st = new StringTokenizer(in.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            elecs[i] = new elec(start, end);
        }

        Arrays.sort(elecs, (e1, e2) -> {
            return e1.start - e2.start;
        });

        int[] dist = new int[num];
        Arrays.fill(dist, 1);

        int[] start = new int[num];
        int size = 1;

        for(int i=1; i<num; i++){
            for(int j=0; j<i; j++){
                if(elecs[i].end > elecs[j].end && dist[i] < dist[j] + 1)
                    dist[i] = dist[j] + 1;
            }
        }

        int max = -1;
        for(int i=0; i<num; i++)
            max = Math.max(max, dist[i]);

//
//        dist[0] = elecs[0].end;
//        start[0] = elecs[0].start;
//
//        for(int i=1; i<num; i++){
//            if(dist[0] > elecs[i].end){
//                start[0] = elecs[i].start;
//                dist[0] = elecs[i].end;
//            }else if(dist[size-1] < elecs[i].end){
//                start[size] = elecs[i].start;
//                dist[size] = elecs[i].end;
//                size++;
//            }else{
//                int idx = Arrays.binarySearch(dist, 0, size-1, elecs[i].end);
//                if(idx < 0)
//                    idx = -1-idx;
//                start[idx] = elecs[i].start;
//                dist[idx] = elecs[i].end;
//            }
//        }
        // out.write(num - size) + "\n");

        out.write((num-max)+"\n");
        out.flush();
        in.close();
        out.close();
    }
}
