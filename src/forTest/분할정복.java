package forTest;

public class 분할정복 {
	int[] arr = {6, 2, 9, 8, 1, 4, 17, 5};
	
	public int findMax(int low, int high) {
		
		int mid = (low + high)/2;
		if(low == high) return arr[low];
		
		int left = findMax(low, mid);
		int right = findMax(mid+1, high);
		
		return (left > right) ? left : right;
	}
}
