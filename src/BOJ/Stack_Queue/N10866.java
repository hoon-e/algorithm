package BOJ.Stack_Queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();

        while(num-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "push_back":
                    int data2 = Integer.parseInt(st.nextToken());
                    d.addLast(data2);
                    break;
                case "push_front":
                    int data = Integer.parseInt(st.nextToken());
                    d.addFirst(data);
                    break;
                case "pop_back":
                    if( d.size() == 0 )
                        bw.write(-1+"\n");
                    else
                        bw.write(d.pollLast() + "\n");
                    break;
                case "pop_front":
                    if( d.size() == 0 )
                        bw.write(-1+"\n");
                    else
                        bw.write(d.poll() + "\n");
                    break;
                case "back":
                    if(d.peekLast() == null)
                        bw.write(-1+"\n");
                    else
                        bw.write(d.peekLast() + "\n");
                    break;
                case "front":
                    if(d.peek() == null)
                        bw.write(-1+"\n");
                    else
                        bw.write(d.peek() + "\n");
                    break;
                case "size":
                    bw.write(d.size()+"\n");
                    break;
                case "empty":
                    if(d.isEmpty())
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
