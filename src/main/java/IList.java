public interface IList<E> {

    void add(E element);

    void add(E element, int index);

    void remove(int index);

    E get(int index);

    boolean contains(E element);

}
