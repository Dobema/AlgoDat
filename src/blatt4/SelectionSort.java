package blatt4;

public class SelectionSort<E extends Comparable<E>> implements Sort<E> {
	
	public void sort(DataStructureOperator<E> dataStructureOperator) {
		for (int i = 0; i < dataStructureOperator.numberOfElements()-1; i++) {
			int k = i;
			for (int j = i+1; j < dataStructureOperator.numberOfElements(); j++) {
				if(dataStructureOperator.lessThan(j, k)) {
			 	k = j;
				}
			
				if(i != k && j == dataStructureOperator.numberOfElements()-1) {
				dataStructureOperator.exchange(i, k);
				}
			}
		}
	}
	
	public void sort(E[] array) {
		for (int i = 0; i < array.length-1; i++) {
			
			int k = i;
			for (int j = i+1; j > array.length; j++) {
				if(array[j].compareTo(array[k]) < 0) {
					 k = j;
				}
			
			if(i != k && j == array.length-1) {
			E temp = array[i];
			array[i] = array[k];
			array[k] = temp;
			}
			}
		}
	}
}
