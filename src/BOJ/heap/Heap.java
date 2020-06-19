package BOJ.heap;

import java.io.*;
import java.util.*;

public class Heap {
    private int[] data;
    private int size;
    private int maxSize;

    public Heap(){
        data = new int[100];
    }

    public static void main(String[] args){
        int[] arr = new int[5];

        for(int i : arr)
            System.out.println(i);
    }

    public Heap(int maxSize){
        if(maxSize < 1)
            this.maxSize = 100;
        else
            this.maxSize = maxSize;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == 100;
    }

    public void clear(){
        data = null;
    }

    public void insert(int item){
        int ptr;

        if(isFull()){
            // Heap이 꽉차있다면 Exception 처리
            throw new IndexOutOfBoundsException();
        }else{
            data[size] = item;
            ptr = size;
            ++size;
        }

        while(ptr > 0 && data[ptr] > data[(ptr-1)/2]){
            // 최대 힙에서 자식 노드는 부모노드보다 작거나 같다
            // 끝에 삽입된 노드를 부모노드와 비교하여, 크다면 부모 노드와 교체한다.
            int temp = data[(ptr-1)/2];
            data[ptr] = data[(ptr-1)/2];
            data[(ptr-1)/2] = temp;
            ptr = (ptr-1)/2;
        }
    }

    public int remove(){
        int toReturn;

        if(!isEmpty()){
            toReturn = data[0];
            // 가장 끝에 존재하는 노드를 Root에 집어넣는다.
            data[0] = data[--size];
            data[size] = 0;
        }else{
            throw new EmptyStackException();
        }


        // Heap 재정렬
        fixRoot();
        return toReturn;
    }

    public void fixRoot(){
        // remove 메소드에서 가장 큰 노드, 루트 노드를 제거하고, 그 자리에 가장 끝에 있는 노드를 삽입한다.
        // 다시 힙을 재정렬한다.

        int ptr = 0;

        while( 2*ptr + 1 < size){
            // 자식 노드 중 더 큰 노드와 자리를 교체
            if(data[2 * ptr + 1] > data[ 2 * ptr + 2]){
                int temp = data[ptr];
                data[ptr] = data[2*ptr + 1];
                ptr = 2*ptr + 1;
            }else {
                int temp = data[ptr];
                data[ptr] = data[2*ptr + 2];
                data[2*ptr + 2] = temp;
                ptr = 2*ptr + 2;
            }
        }
    }
}
