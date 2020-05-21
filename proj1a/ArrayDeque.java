public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int size;
    private int fullSize;
    private int front;
    private int end;

    public ArrayDeque() {
        fullSize = 8;
        front = 0; // point at the first item
        end = 0;  // point at the next of the last item
        size = 0;
        array = (T[]) new Object[fullSize];
    }

    public ArrayDeque(ArrayDeque<T> other) {
        array = (T[]) new Object[other.fullSize];
        front = other.front;
        end = other.end;
        size = other.size;
        array = other.array.clone();
    }

    private void resize(double factor) {
        T[] newArray = (T[]) new Object[fullSize * 2];
        int i = 0;
        int j = front;
        while (i < size) {
            newArray[i] = array[j];
            i += 1;
            j = (j + 1) % fullSize;
        }
        fullSize *= factor;
        array = newArray;
        front = 0;
        end = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == fullSize) {
            resize(2);
        }
        front = (front - 1 + fullSize) % fullSize;
        array[front] = item;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == fullSize) {
            resize(2);
        }
        array[end] = item;
        end = (end + 1) % fullSize;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int i = 0;
        int j = front;
        while (i < size) {
            System.out.print(array[j]);
            i += 1;
            j = (j + 1) % fullSize;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T value = array[front];
        array[front] = null;
        front = (front + 1) % 8;
        size -= 1;
        if ((fullSize > 16) && (size < fullSize / 4)) {
            resize(0.5);
        }
        return value;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        end = (end - 1 + fullSize) % fullSize;
        T value = array[end];
        array[end] = null;
        size -= 1;
        if ((fullSize > 16) && (size < fullSize / 4)) {
            resize(0.5);
        }
        return value;
    }

    @Override
    public T get(int index) {
        int idx = (index + front) % fullSize;
        return array[idx];
    }
}
