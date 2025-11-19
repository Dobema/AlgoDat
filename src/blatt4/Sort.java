package blatt4;

public interface Sort<E extends Comparable<E>>{
	void sort(DataStructureOperator<E> dataStructureOperator);
	void sort(E[] array);
}
