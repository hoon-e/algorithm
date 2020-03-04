package theory;

/*
 * 이진 탐색은 미리 정렬이 되어있어야한다.
 */
public class Binary_Search {
	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 8, 9, 11, 14, 20};
		bs(14, data);	
	}
	
	public static void bs(int key, int data[]) {
		int middle;
		int left = 0;
		int right = data.length-1;
		
		while(right>=left) {
			middle = (left+right)/2;
			
			if(key == data[middle]) {
				System.out.println("find the key at " + (middle+1));
				break;
			}
			
			if(key < data[middle]) {
				right = middle-1;
			}else {
				left = middle+1;
			}
		}
	}
}
