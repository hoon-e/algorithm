package BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class n2644 {
    static class People {
        int num;
        int chon;

        People(int num, int chon){
            this.num = num;
            this.chon = chon;
        }
    }

    static ArrayList<People>[] people;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<People> chon = new LinkedList<>();

        int n = Integer.parseInt(in.readLine());
        people = new ArrayList[n+1];

        boolean[] vst = new boolean[n+1];

        for(int i=0; i<=n; i++)
            people[i] = new ArrayList<>();

        st = new StringTokenizer(in.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(in.readLine());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            people[v].add(new People(u, 1));
            people[u].add(new People(v, 1));
        }

        chon.offer(new People(a, 0));
        vst[a] = true;

        int result = 0;

        while(!chon.isEmpty()){
            People cur = chon.poll();

            if(cur.num == b) {
                result = cur.chon;
                break;
            }

            for(People next : people[cur.num]){
                if(!vst[next.num]){
                    vst[next.num] = true;
                    next.chon = cur.chon + 1;
                    chon.offer(new People(next.num, next.chon));
                }
            }
        }

        out.write(result == 0 ? -1 + "\n" : result + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
