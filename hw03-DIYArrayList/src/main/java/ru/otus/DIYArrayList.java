package ru.otus;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DIYArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elements;

    public DIYArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T t) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, newCapacity());
        }
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        int cursor;
        int lastRet = -1;

        Iter() {
        }

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size()) {
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            T nextElement = (T) get(cursor);
            cursor++;
            return nextElement;
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldValue = (T) elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(0)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIter(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    private class ListIter extends Iter implements ListIterator<T> {
        ListIter(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T previous() {
            return (T) elements[--cursor];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {
            DIYArrayList.this.set(lastRet, t);
        }

        @Override
        public void add(T t) {
            elements[++cursor] = t;
        }
    }

    private int newCapacity() {
        return size * 2;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

}

