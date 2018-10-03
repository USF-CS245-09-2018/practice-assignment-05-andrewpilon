// Andrew Pilon

public class QuickSort implements SortingAlgorithm {
	
	public void sort(int [] arr) {
		quicksort(arr, 0, arr.length-1);
	}
	
	public void quicksort(int [] arr, int lower, int upper) {
		if(lower>=upper) { // check if we should be finished with sorting
			return;
		}
		int pivot = arr[(lower+upper)/2];
		int idx = partition(arr, lower, upper, pivot);
		quicksort(arr, lower, idx-1);
		quicksort(arr, idx, upper);
	}
	
	public int partition(int [] arr, int lower, int upper, int pivot) {
		while(lower<=upper) { // move pointers toward middle from edges of partition
			while(arr[lower]<pivot) { // get value>pivot on left
				lower++;
			}
			while(arr[upper]>pivot) { // get value<pivot on right
				upper--;
			}
			if(lower<=upper) {
				// swap elements, increment indices again
				int temp = arr[upper];
				arr[upper] = arr[lower];
				arr[lower] = temp;
				lower++;
				upper--;
			}
		}
		return lower; // this is the point to be returned as the partition
	}
}