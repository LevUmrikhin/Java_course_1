package ru.isys.trainings.task8;

import java.util.Iterator;
import java.util.List;

import java.util.NoSuchElementException;

import java.util.function.Consumer;

public class LinkList<E> implements Iterable<E>{
    static class ListItem<E> {
        E data;
        ListItem<E> next;

        ListItem(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListItem<E> head;

    public LinkList() {
        this.head = null;
    }


    public void add(E data) {
        ListItem<E> newListItem = new ListItem<>(data);
        if (head == null) {
            head = newListItem;
        } else {
            ListItem<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newListItem;
        }
    }

    public int size() {
        ListItem<E> current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }


    public void add(int index, E data) {
        ListItem<E> newListItem = new ListItem<E>(data);
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        if (index == 0) {
            newListItem.next = head;
            head = newListItem;
            return;
        }

        ListItem<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            current = current.next;
        }
        newListItem.next = current.next;
        current.next = newListItem;


    }

    public boolean isEmpty() {
        return head == null;
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        ListItem<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            current = current.next;
        }
        if (current.next.next == null) {
            current.next = null;
        } else {
            current.next = current.next.next;
        }

    }

    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        ListItem<E> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            current = current.next;
        }
        return current.data;
    }

    public void clear() {
        head = null;
    }

    public void set(int index, E data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        ListItem<E> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            current = current.next;
        }
        current.data = data;

    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    @Override
    public void forEach(Consumer<? super E> action) {
        for (E element : this) {
            action.accept(element);
        }
    }


    private class ListIterator implements Iterator<E> {

        private ListItem<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;

        }


    }
}