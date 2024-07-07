package Lists;

import Exceptions.incorrectCapasityException;
import Exceptions.incorrectIndexException;
import Exceptions.itemIsNullException;

import java.util.Arrays;
import java.util.Objects;


public class IntegerListImpl implements IntegerList {

    private final static int DEFAULT_CAPACITY = 10;

    private Integer[] storage;
    private int size;

    public IntegerListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerListImpl(int size) {
        if (size <= 0) {
            throw new incorrectCapasityException("capacity should be more then 0");
        }
        storage = new Integer[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public Integer add(Integer item) {
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIsNull(item);
        if (size == storage.length) {
            grow();
        }
        checkIndex(index, false);
        if (index < size) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
        }
        size++;
        return storage[index] = item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIsNull(item);
        checkIndex(index, true);
        return storage[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        return remove(indexOf(item));
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index, true);
        if (index < size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
        Integer removed = storage[index];
        storage[--size] = null;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        checkIsNull(item);
//        for (int i = 0; i < size; i++) {
//            if (storage[i].equals(item)) {
//                return true;
//            }
//        }
//        return false;
        Integer[] copy = toArray();
        quickSort(copy, 0, copy.length - 1);
        return contains(copy, item);
    }

    @Override
    public int indexOf(Integer item) {
        checkIsNull(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkIsNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index, true);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!storage[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void grow() {
        storage = Arrays.copyOf(storage, storage.length * 3 / 2);
    }

    private static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        Integer pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] array, int i, int j) {
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static boolean contains(Integer[] arr, Integer element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element.equals(arr[mid])) {
                return true;
            }

            if (element.compareTo(arr[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void checkIsNull(Integer item) {
        if (Objects.isNull(item)) {
            throw new itemIsNullException();

        }
    }

    private void checkIndex(int index, boolean include) {
        if (index < 0 || include ? index >= size : index > size) {
            throw new incorrectIndexException();
        }
    }

}
