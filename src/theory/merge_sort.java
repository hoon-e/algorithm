package theory;

import java.util.Arrays;

public class merge_sort {
	public static void main(String[] args) {
		int[] data = {9, 3, 93, 69, 50, 100, 27, 81};
		int size = data.length;
		System.out.println("병합 정렬 전 : " + Arrays.toString(data));
		System.out.println("------------------------------------");
		mergeSort(data, 0, size-1);
	}
	
	public static void mergeSort(int[] data, int left, int right) {
		int middle=0;
		if(left < right) {
			middle=(left+right)/2; // 중간을 middle로 설정한다.
			mergeSort(data, left, middle); // 왼쪽을 나눈다.
			mergeSort(data, middle+1, right); // 오른쪽을 나눈다.
			merge(data, left, middle, right); // 왼쪽 오른쪽 나눈 부분을 서로 합친다.
		}
	}
	
	public static void merge(int[] data, int left, int middle, int right) {
		int[] sorted = new int[8];
		int i = left; // 첫번째 부분집합의 시작 
		int j = middle+1; // 두번째 부분 집합의 시작
		int k = left; // 정렬된 원소를 저장할 위치
		
		System.out.print("정렬 할 부분 <인덱스 "+ left+ "부터" + right +"까지>: " + Arrays.toString(data)+" => ");
		while((i<=middle) && j<=right) { // i가 middle보다 작고, j가 right보다 작을 동안 반복한다.
			if(data[i]<=data[j]) { // 왼쪽 부분의 값이 오른쪽 부분의 값보다 작거나 같다면
				sorted[k] = data[i]; // 정렬 배열에 왼쪽 배열의 값을 넣는다.
				i++; // i를 증가시켜 왼쪽 부분의 index를 하나 증가시킨다.
			}else {
				sorted[k] = data[j]; // 반대일 경우 정렬 배열 오른쪽 부분의 값을 넣는다.
				j++; // j를 증가시켜 오른쪽 부분의 index를 하나 증가시킨다.
			}
			k++; // sorted 배열의 값도 증가시킨다.
		}
		// 나머지 남은 값들 추가
		if(i>middle) { // i가 middle보다 클 경우 오른쪽 부분의 값을 추가시켜줘야한다.
			for(int index=j; index<=right; index++,k++) { // 따라서 index를 j부터 시작하여 정렬 배열에 마저 추가시켜준다. 
				sorted[k] = data[index];
			}
		}else { // i가 middle보다 작을 경우에 왼쪽 부분의 값을 마저 추가시켜준다.
			for(int index=i; index<=middle; index++,k++) {
				sorted[k] = data[index];
			}
		}
		
		// left부터 right까지 정렬된 값을 data 배열에 적용 시켜준다.
		for(int index=left; index<=right; index++) {
			data[index] = sorted[index];
		}
		System.out.println("정렬 후 : " +Arrays.toString(data));
		
		// 결과를 보면 왼쪽 부분의 부분 정렬 병합, 이후 오른쪽 부분 정렬 병합, 이후 전체 마지막 병합 후 종료된다.
	}
}
