package theory;

public class quick_sort {
	// 피봇(pivot)을 기준으로 하여서 작은 것은 왼쪽으로, 큰 것은 오른쪽으로 보내는 로직을 기본으로 한다.
	// 재귀함수를 이용한다.
	public static void main(String[] args) {
		int[] data = {1, 10, 5, 9, 7, 4 ,21, 93, 19};
		
		quicksort(data, 0, data.length-1);
		
		for(int w : data) {
			System.out.print(w + " ");
		}
	}
	
	public static int partition(int[] data, int left, int right) {
		int pivot = data[(left+right)/2];
		// 피봇은 중앙으로 설정한다.
		while(left < right) { // left가 right보다 작을 동안
			while((data[left] < pivot) && left < right) { // data[left]가 피봇보다 작고, left가 right보다 작을 때까지
				left++;
			}
			while((data[right] > pivot) && left < right) { // data[right]가 피봇보다 크고, left가 right보다 작을 때까지
				right--;
			}
			
			if(left < right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
			}
		}
		
		return left;
	}
	
	public static void quicksort(int[] data, int left, int right) {
		if( left < right ) {
			int pivot = partition(data, left, right); // partition함수를 통해 pivot을 정한다.
			
			quicksort(data, left, pivot-1);
			quicksort(data, pivot+1, right);
		}
	}
}
