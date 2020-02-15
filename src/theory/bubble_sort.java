package theory;

public class bubble_sort {

	public static void main(String[] args) {
		double dnum = Math.random();
		int num = (int)(dnum*20)+1;
		System.out.println(num);
		
		int[] data = new int[num];
		
		for(int i=0; i<num; i++) {
			dnum = Math.random();
			data[i] = (int)(dnum*40);
		}
		bubblesort(data);
	}
	
	static void bubblesort(int[] data) {
		for(int i=0; i<data.length-1; i++) {
			boolean swap = false;
			for(int j=0; j<data.length-i-1; j++) {
				if(data[j] > data[j+1]) {
					int temp = data[j+1];
					data[j+1] = data[j];
					data[j] = temp;
					swap = true;
				}
			}
			if(swap == false)
				break;
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
