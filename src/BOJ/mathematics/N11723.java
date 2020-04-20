package BOJ.mathematics;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class mySet {
    ArrayList<Integer> hi;

    mySet(){
        hi = new ArrayList<>();
    }

    public void add(int x){
        if(!hi.isEmpty()){
            for(int num : hi){
                if(num == x)
                    return;
            }
            hi.add(x);
        }else
            hi.add(x);
    }

    public void remove(int x){
        if(!hi.isEmpty()){
            for(int num : hi){
                if(num == x) {
                    hi.remove((Integer)x);
                    return;
                }
            }
        }
    }

    public int check(int x){
        if(!hi.isEmpty()){
            for(int num : hi){
                if(num == x)
                    return 1;
            }
        }
        return 0;
    }

    public void toggle(int x){
        if(!hi.isEmpty()){
            for(int num : hi){
                if(num == x) {
                    hi.remove((Integer)x);
                    return;
                }
            }
        }
        hi.add(x);
    }

    public void all(){
        hi.clear();

        for(int i=1; i<=20; i++)
            hi.add(i);
    }

    public void empty(){
        hi.clear();
    }
}

public class N11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        mySet ms = new mySet();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num;
            switch(st.nextToken()){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    ms.add(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    bw.write(ms.check(num)+"\n");
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    ms.remove(num);
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    ms.toggle(num);
                    break;
                case "all":
                    ms.all();
                    break;
                case "empty":
                    ms.empty();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}