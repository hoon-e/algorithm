package theory;

public class selection_sort {
	public static void main(String[] args) {
		double dnum = Math.random();
		int num = (int)(dnum*20)+1;
		System.out.println(num);
		
		int[] data = new int[num];
		
		for(int i=0; i<num; i++) {
			dnum = Math.random();
			data[i] = (int)(dnum*40);
		}
		selection(data);
	}
	
	static void selection(int[] data) {
		for(int stand=0; stand<data.length-1; stand++) {
			int lowest = stand;
			for(int index=stand+1; index<data.length; index++) {
				if(data[lowest] > data[index]) {
					lowest = index;
				}
			}
			int temp = data[lowest];
			data[lowest] = data[stand];
			data[stand]= temp;
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
