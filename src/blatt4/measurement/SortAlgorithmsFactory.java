package blatt4.measurement;

import java.util.Map;

import blatt4.BubbleSort;
import blatt4.InsertionSort;
import blatt4.SelectionSort;
import blatt4.ShellSort;
import blatt4.Sort;

public class SortAlgorithmsFactory<E extends Comparable<E>> {
	
	public static final String BUBBLE_SORT = "BubbleSort";
	public static final String INSERTION_SORT = "InsertionSort";
	public static final String SHELL_SORT = "ShellSort";
	public static final String SELECTION_SORT = "SelectionSort";
	

	
	private final Map<String, Sort<E>> knownSortAlgorithms = Map.ofEntries(
			Map.entry(BUBBLE_SORT, new BubbleSort<>()),
			Map.entry(SELECTION_SORT, new SelectionSort<>()),
			Map.entry(INSERTION_SORT, new InsertionSort<>()),
			Map.entry(SHELL_SORT, new ShellSort<>())
		    
		);
	
	public Sort<E> createSortAlgorithm(String algorithmName) {
		return knownSortAlgorithms.get(algorithmName);
	}
}
