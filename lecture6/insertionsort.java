package lecture6;

public class insertionsort {

	public static void main(String[] args) {
		int[] arr = { 5,1,10,76,34,0,3,80,25,6,91,90 };
		arrayops.display(arr);
		insertionSort(arr);
		arrayops.display(arr);
	}


	public static void insertionSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {   //array to lest of this index will b sorted
			
			for(int i = counter; i > 0; i--){  
				if(arr[i] < arr[i - 1]){
					swaparrayelements.swap(arr, i, i - 1);
				}
				else {
					break;
				}           
				arrayops.display(arr);
			}

			counter++;
		}
	}

}
