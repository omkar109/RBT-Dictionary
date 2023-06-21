// --== CS400 Spring 2023 File Header Information ==--
// Name: Omkar Kendale
// Email: kendale@wisc.edu
// Team: DK
// TA: Yuye Jiang
// Lecturer: Florain Heimerl
// Notes to Grader: <optional extra notes>

public interface SortedCollectionInterface<T extends Comparable<T>>{

    public boolean insert(T data) throws NullPointerException, IllegalArgumentException;

    public boolean remove(T data) throws NullPointerException, IllegalArgumentException;

    public boolean contains(T data);

    public int size();

    public boolean isEmpty();

}
