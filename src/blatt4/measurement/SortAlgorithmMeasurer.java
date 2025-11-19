package blatt4.measurement;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import blatt4.ArrayOperator;
import blatt4.Sort;

public class SortAlgorithmMeasurer {
	
	private static final Random RANDOM = new Random();
	
	public class MeasurementResult {
		private long elapsedTime;
		private long numberOfComparisons;
		private long numberOfExchanges;
		
		public MeasurementResult(long elapsedTime, long numberOfComparisons, long numberOfExchanges) {
			this.elapsedTime = elapsedTime;
			this.numberOfComparisons = numberOfComparisons;
			this.numberOfExchanges = numberOfExchanges;
		}
		
		public long getElapsedTime() {
			return elapsedTime;
		}
		
		public long getNumberOfComparisons() {
			return numberOfComparisons;
		}

		public long getNumberOfExchanges() {
			return numberOfExchanges;
		}
		
		public String toString() {
			return "Elapsed time "+elapsedTime+"ms, "+numberOfComparisons+" comparisons, "+numberOfExchanges+" exchanges";
		}
	}
	
	public MeasurementResult measure(Sort<Integer> sortAlgorithm, int numberOfElements) {
		Integer[] values = RANDOM.ints(numberOfElements, Integer.MIN_VALUE, Integer.MAX_VALUE).boxed().toArray( Integer[]::new );
		ArrayOperator<Integer> arrayOperator = new ArrayOperator<>(values);
		long elapsed = measure(() -> sortAlgorithm.sort(arrayOperator));
		return new MeasurementResult(elapsed, arrayOperator.getComparisons(), arrayOperator.getExchanges());
	}
	
	public void doublingMeasurement(Sort<Integer> sortAlgorithm, int maximumIterations) {
		int numberOfElements = 250;
		for (int i = 0; i < maximumIterations; i++) {
			MeasurementResult measurementResult = measure(sortAlgorithm, numberOfElements);
			System.out.println(sortAlgorithm.getClass().getSimpleName()+" "+numberOfElements+" -> "+measurementResult);
			numberOfElements+=numberOfElements;
		}
	}
	
	public void pairwiseComparison(Sort<Integer> sortAlgorithm1, Sort<Integer> sortAlgorithm2, int numberOfElements) {
		double result1 = measure(sortAlgorithm1, numberOfElements).elapsedTime;
		double result2 = measure(sortAlgorithm2, numberOfElements).elapsedTime;
		System.out.print("For "+numberOfElements+" elements ");
		Sort<Integer> faster, slower;
		double ratio;
		if (result1 <= result2) {
			faster = sortAlgorithm1;
			slower = sortAlgorithm2;
			ratio = result2/result1;
		}
		else {
			faster = sortAlgorithm2;
			slower = sortAlgorithm1;
			ratio = result1/result2;
		}
		System.out.println(faster.getClass().getSimpleName()+" is "+new DecimalFormat("0.00").format(ratio)+" times faster than "+slower.getClass().getSimpleName());
	}
	
	public static long measure(Runnable function) {
		Instant start = Instant.now();
		function.run();
		Instant stop = Instant.now();
		return Duration.between(start, stop).toMillis();
	}
}
