package blatt4.measurement;

public class SortStarter {

	private static final int NUMBER_OF_ITERATIONS = 8;
	private static final int NUMBER_OF_ELEMENTS = 10000;
	
	public static void main(String[] args) {
		//String task = "PairwiseComparison";
		String task = "DoublingMeasurement";
		String[] algorithms = {SortAlgorithmsFactory.INSERTION_SORT, SortAlgorithmsFactory.SELECTION_SORT};
		SortAlgorithmMeasurer measurer = new SortAlgorithmMeasurer();
		SortAlgorithmsFactory<Integer> algorithmFactory = new SortAlgorithmsFactory<>();
		switch (task) {
		case "PairwiseComparison": pairwiseComparison(algorithms, measurer, algorithmFactory); break;
		case "DoublingMeasurement": doublingMeasurement(algorithms, measurer, algorithmFactory); break; 
		}
	}

	private static void doublingMeasurement(String[] algorithms, SortAlgorithmMeasurer measurer,
			SortAlgorithmsFactory<Integer> algorithmFactory) {
		for (String algorithmName : algorithms) {
			new Thread(() -> measurer.doublingMeasurement(algorithmFactory.createSortAlgorithm(algorithmName), NUMBER_OF_ITERATIONS)).start();
		}
}

	private static void pairwiseComparison(String[] algorithms, SortAlgorithmMeasurer measurer,
			SortAlgorithmsFactory<Integer> algorithmFactory) {
		for (int i = 0; i < algorithms.length; i++) {
			for(int j=i+1; j < algorithms.length; j++) {
				measurer.pairwiseComparison(algorithmFactory.createSortAlgorithm(algorithms[i]), algorithmFactory.createSortAlgorithm(algorithms[j]), NUMBER_OF_ELEMENTS);
			}
		}
	}
}
