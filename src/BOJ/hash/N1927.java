package BOJ.hash;

import java.io.*;
import java.util.ArrayList;

public class N1927 {
    // 최소힙 문제
    public static class MinHeap {
        private ArrayList<Integer> heap;

        public MinHeap(){
            heap = new ArrayList<>();
            heap.add(0);
        }

        // 값 추가
        public void insert(int val){
            heap.add(val);
            int size = heap.size() - 1;

            // 부모보다 자식 노드가 더 작다면 바꿔야한다.
            while(size > 1 && heap.get(size/2) > heap.get(size)){
                int temp = heap.get(size/2);
                heap.set(size/2, heap.get(size));
                heap.set(size, temp);

                size = size/2;
            }
        }

        public int delete(){
            if(heap.size() - 1 < 1)
                return 0;

            // 최소힙 이므로 삭제할 노드는 루트 노드가 된다.
            int deleteItem = heap.get(1);

            // 가장 마지막에 있는 노드와 루트노드를 변경하여 루트노드를 삭제하는데 오류가 없게 한다.
            heap.set(1, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);

            int pos = 1;

            while((pos * 2) < heap.size()){
                int min = heap.get(pos * 2);
                int minPos = pos * 2;

                // 오른쪽의 값이 힙의 크기보다 작고, 최솟값이 오른쪽 힙의 값보다 작을때
                if((pos * 2 + 1) < heap.size() && min > heap.get(pos * 2 + 1)){
                    min = heap.get(pos * 2 + 1);
                    minPos = pos * 2 + 1;
                }

                if(heap.get(pos) < min) // pos
                    break;

                int temp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, temp);
                pos = minPos;
            }
            return deleteItem;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        MinHeap heap = new MinHeap();

        for(int i=0; i<num; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0)
                bw.write(heap.delete()+"\n");
            else
                heap.insert(n);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
