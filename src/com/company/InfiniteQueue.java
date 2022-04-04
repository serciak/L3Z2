package com.company;

public class InfiniteQueue<E> {
    OneWayLinkedList<E> list;

    public InfiniteQueue() {
        list = new OneWayLinkedList<>();
    }

    public String toString() {
        return list.toString();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        E value = list.remove(0);
        return value;
    }

    public E first() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        E value = list.get(0);
        return value;
    }

    public int size() {
        return list.size();
    }
}
