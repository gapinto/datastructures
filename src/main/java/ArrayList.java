public class ArrayList<E> implements IList<E> {

    private Object[] elements;
    private int totalElements;

    public ArrayList(int size){
        if(size > 0) {
            this.elements = new Object[size];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        }
    }

    public void add(E element) {
        this.checkSizeArray();
        this.elements[this.totalElements] = element;
        this.totalElements ++;
    }

    private void checkSizeArray() {
        Object[] newArray;
        if(this.totalElements == this.elements.length) {
            newArray = new Object[this.totalElements * 2];
            for (int i = 0; i < this.totalElements; i++) {
                newArray[i] = this.elements[i];
            }
            this.elements = newArray;
        }
    }

    public void add(E element, int index) {
        this.checkSizeArray();
        //Evitar buracos no array
        if(isValidIndex(index)) {
            shiftForAdd(element, index);
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    /**
     * Se o index passado for igual ao total de elementos do array
     * Teremos que adicionar, já que não podemos passar por cima de um existente.
     * Se não temos que fazer o shiftForAdd.
     * @param element
     * @param index
     */
    private void shiftForAdd(Object element, int index) {
        if(index < this.totalElements) {
            Object actual = this.elements[index];
            this.elements[index] = element;
            shiftForAdd(actual, ++index );
        } else {
            add((E)element);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.totalElements;
    }

    public void remove(int index) {
        if(isIndexInUse(index)) {
            this.elements[index] = null;
            shiftForRemove(index);
            -- this.totalElements;
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    private void shiftForRemove(int index) {
        int nextElement = index + 1;
        if(nextElement < totalElements) {
            this.elements[index] = this.elements[index +1];
            shiftForRemove(++index);
        } else {
            this.elements[index] = null;
        }
    }

    private boolean isIndexInUse(int index) {
        return index >= 0 && index < this.totalElements;
    }

    public E get(int index) {
        if(isIndexInUse(index)) {
            return (E)this.elements[index];
        }

        throw new IllegalArgumentException("Invalid index: " + index);

    }

    public boolean contains(E element) {
        boolean result = false;
        for (int i = 0; i < this.totalElements; i++) {
            if(this.elements[i].equals(element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.totalElements; i++) {
            Object element = this.elements[i];
            sb.append(element);
            if(i < this.totalElements -1)
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
