package BOJ.bojsolve3;

import java.io.*;
import java.util.StringTokenizer;

class Que<Integer> {
    static class Node<Integer>{
        private int data;
        private Node<Integer> next;

        public Node(int data){
            this.data = data;
        }
    }

    private Node<Integer> first;
    private Node<Integer> last;
    private int count = 0;

    public void add(int item){
        Node<Integer> temp = new Node<Integer>(item);
        count++;

        if(last != null)
            last.next = temp;
        last = temp;
        if(first == null) // first가 null일 경우 first는 last이다.
            first = last;
    }

    public int pop(){
        if(first == null)
            return -1;

        int data = first.data;
        first = first.next;
        count--;

        if(first == null){
            last = null;
            count = 0;
        }

        return data;
    }

    public int peek(){
        if(first == null){
            return -1;
        }
        return first.data;
    }

    public int back(){
        if(last == null)
            return -1;
        return last.data;
    }

    public int size(){
        return count;
    }

    public int isEmpty(){
        if(first == null)
            return 1;
        else
            return 0;
    }
}

public class N10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Que<Integer> q = new Que<>();

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push":
                    int item = Integer.parseInt(st.nextToken());
                    q.add(item);
                    break;
                case "front":
                    bw.write(q.peek() + "\n");
                    break;
                case "back":
                    bw.write(q.back() +"\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "pop":
                    bw.write(q.pop() + "\n");
                    break;
                case "empty":
                    bw.write(q.isEmpty() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
