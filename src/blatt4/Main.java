package blatt4;

import java.util.Arrays;

public class Main {

	
	
	public static void main(String[] args) {
		int [] unsortiert = {};
		//unsortiert = new int[]{12, 7, 8, 13, 6, 4, 1, 14, 2, 9, 10, 11, 3, 5};
		//unsortiert = arraySortiert(unsortiert); // richtig herum sortiertes Array
		unsortiert = arrayBackwardsSortiert(unsortiert); // falsch herum sortiertes Array
		
		int[] sortiert = insertionSort(unsortiert); 	//Sortieren mit Insertion Sort
		//int[] sortiert = selectionsort(unsortiert);		//Sortieren mit Selection Sort
		
		for (int i = 0; i < sortiert.length; i++) {
			System.out.print(sortiert[i] + ", ");
		}
		

	}
	
	static int[] arraySortiert(int[] unsortiert) {
		for(int i = 00; i <= 10000; i++) {
			unsortiert = addElement(unsortiert, i);
		}
		return unsortiert;
	}
	
	static int[] arrayBackwardsSortiert(int[] unsortiert) {
		for(int i = 10000; i >= 0; i--) {
			unsortiert = addElement(unsortiert, i);
		}
		return unsortiert;
	}
	

	static int[] addElement(int[] a, int e) {
		a = Arrays.copyOf(a, a.length+1);
		a[a.length -1] = e;
		return a;
	}
	
	public static int[] insertionSort(int[] array) {
		int verschiebung = 0;
		int vergleiche = 0;
		for (int i = 1; i < array.length; i++) {
			vergleiche++;
			for (int j = i; j > 0 && array[j] <  array[j-1]; j--) {
				vergleiche++;
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				verschiebung++;
				
			} 
		}
		System.out.print("VVergleiche "  + vergleiche + ": ");
		System.out.print("Vertauschungen "  + verschiebung + ": ");
		return array;
	}

	
	public static int[] selectionsort(int[] array) {
		int verschiebungen = 0;
		int vergleiche = 0;
		for (int i = 0; i < array.length-1; i++) {

			int k = i;
			
			for (int j = i+1 ; j < array.length; j++) {
				vergleiche++;
				if(array[j] < array[k] ) {
				 k = j;
				 
				}
				if(i != k && j == array.length-1) {
					verschiebungen = verschiebungen +1;
					int temp = array[i];
					array[i] = array[k];
					array[k] = temp;
				}
			}
			
		}
		System.out.print("Vergleiche "  + vergleiche + ": ");
		System.out.print("Vertauschungen "  + verschiebungen + ": ");
		return array;
	}
	
	
}
