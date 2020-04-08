package BOJ.hash;

import java.io.*;
import java.util.ArrayList;

// TODO : MAXHEAP
public class N11279 {
    static class MaxHeap {
        private ArrayList<Integer> heap;

        MaxHeap(){
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int value){
            heap.add(value);
            int size = heap.size()-1;

            // 부모 노드가 자식 노드보다 작을 경우에 바꿔주어야한다.
            while(size > 1 && heap.get(size/2) < heap.get(size)){
                int temp = heap.get(size/2);
                heap.set(size/2, heap.get(size));
                heap.set(size, temp);

                size = size/2;
            }
        }

        public int delete(){
            if(heap.size() == 1)
                return 0;

            int deleteItem = heap.get(1);

            heap.set(1, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);

            int pos = 1;

            while((pos*2) < heap.size()){
                int maxPos = pos*2;
                int max = heap.get(maxPos);

                if((pos*2+1) < heap.size() && max < heap.get(pos*2+1)){
                    max = heap.get(pos*2+1);
                    maxPos = pos*2+1;
                }

                if( heap.get(pos) > max )
                    break;

                int temp = heap.get(pos);
                heap.set(pos, heap.get(maxPos));
                heap.set(maxPos, temp);
                pos = maxPos;
            }
            return deleteItem;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        MaxHeap heap = new MaxHeap();

        for(int i=0; i<num; i++){
            int val = Integer.parseInt(br.readLine());

            if(val == 0)
                bw.write(heap.delete()+"\n");
            else
                heap.insert(val);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
