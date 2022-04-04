package com.company;

public class CilcularBuffer<T> {
    private T[] array;
    private int maxSize;
    private int takenSize;
    private int writePosition;

    public CilcularBuffer(int maxSize) {
        array = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
        takenSize = 0;
    }
    public CilcularBuffer() {
        array = (T[]) new Object[maxSize];
        this.maxSize = 16;
        takenSize = 0;
    }

    public boolean isFull() {return takenSize == maxSize;}
    public boolean isEmpty() {return takenSize == 0;}

    public void enqueue(T elem) throws FullQueueException {
        if(takenSize < maxSize) {
            if(writePosition >= maxSize) {
                writePosition = 0;
            }
            array[writePosition] = elem;
            writePosition++;
            takenSize++;
        } else {
            throw new FullQueueException();
        }
    }

    public T dequeue() throws EmptyQueueException {
        if(takenSize == 0)
            throw new EmptyQueueException();

        int readPosition = writePosition - takenSize;
        if(readPosition < 0) {
            readPosition += maxSize;
        }
        takenSize--;
        return array[readPosition];
    }

}
