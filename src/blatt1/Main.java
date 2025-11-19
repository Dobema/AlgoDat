package blatt1;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		int numberOfElements = 10;
		if (args.length > 0) {
			numberOfElements = Integer.parseInt(args[0]);
		}

		List<Integer> linkedList = new LinkedList<>();
		fillList(linkedList, numberOfElements);
		
		
		System.out.println("--- LinkedList printed in for loop  ---");
		printListInForLoop(linkedList);
		
		System.out.println("--- LinkedList printed Successor Zugriffe ---");
		printSuccessorZugriff(linkedList);

		System.out.println("--- LinkedList printed in for loop with iterator ---");
		printListInForLoopWithIterator(linkedList);
		
		System.out.println("--- LinkedList printed Successor Zugriffe Iterator ---");
		printSuccessorZugriffIterator(linkedList);

		System.out.println("--- LinkedList printed in foreach loop ---");
		printListInForeachLoop(linkedList);
		
		
		List<Integer> arrayList = new ArrayList<>();
		fillList(arrayList, numberOfElements);
		System.out.println("--- ArrayList printed in for loop  ---");
		printListInForLoop(arrayList);
		
		System.out.println("--- ArrayList printed Successor Zugriffe ---");
		printSuccessorZugriff(arrayList);

		System.out.println("--- ArrayList printed in for loop with iterator ---");
		printListInForLoopWithIterator(arrayList);
		
		System.out.println("--- LinkedList printed Successor Zugriffe Iterator ---");
		printSuccessorZugriffIterator(arrayList);

		
		System.out.println("--- ArrayList printed in foreach loop ---");
		printListInForeachLoop(arrayList);

	}

	private static <E> void printListInForLoopWithIterator(List<E> list) {
		for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next() + "  ");
		}
		System.out.println("\n");
	}

	private static <E> void printListInForeachLoop(List<E> list) {
		for (E element : list) {
			System.out.print(element + "  ");
		}
		System.out.println("\n");
	}

	private static <E> void printListInForLoop(List<E> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "  ");
		}
		System.out.println("\n");
	}

	private static void fillList(List<Integer> list, int numberOfElements) {
		for (int i = 1; i <= numberOfElements; i++) {
			list.add(i * i);
		}
	}
	
	private static <E> void printSuccessorZugriffIterator(List<E> list) {
		
		System.out.println(list.returnZugriffIterator());
		System.out.println("\n");
		
	}
	
	
	private static <E> void printSuccessorZugriff(List<E> list) {
		
		System.out.println(list.returnGetZugriff());
		System.out.println("\n");
	}
}
