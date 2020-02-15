package theory;

public class insert_sort {
	public static void main(String[] args) {
		double dnum = Math.random();
		int num = (int)(dnum*20)+1;
		System.out.println(num);
		
		int[] data = new int[num];
		
		for(int i=0; i<num; i++) {
			dnum = Math.random();
			data[i] = (int)(dnum*40);
		}
		
		ins_sort(data);
	}
	
	static void ins_sort(int[] arr) {
		for(int i=0; i<arr.length-1;i ++) {
			for(int j=i+1; j>0; j--) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
				else
					break;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
