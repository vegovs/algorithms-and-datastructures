public class InsertionSort{

	private static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int j = i-1;
			int tmp = arr[i];

			System.out.println("Testing: " + tmp);

			while(j >= 0 && arr[j] > tmp){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = tmp;
		}
	}

	public static void main(String[] args){

		int[] arr = {4,5,9,2,1,6};

		for(int i: arr){
			System.out.print(i + " ");
		}

		insertionSort(arr);

		for(int i: arr){
			System.out.print(i + " ");
		}
	}
}
