package com.company;

public class Main {

    public static InfiniteQueue<Process> generate(int amount) {
        InfiniteQueue<Process> processes = new InfiniteQueue<>();

        for(int i = 0; i < amount; i++) {
            processes.enqueue(new Process(i+1));
        }
        return processes;
    }

    public static InfiniteQueue<Process> transferProcesses(InfiniteQueue<Process> p) throws EmptyQueueException, FullQueueException {
        CilcularBuffer<Process> cb = new CilcularBuffer<>(64);
        InfiniteQueue<Process> done = new InfiniteQueue<>();
        int quant = 4;
        int startSize = p.size();
        Process temp;

        while(!p.isEmpty() || !(done.size() == startSize)) {
            if(cb.isEmpty()) {
                while(!cb.isFull() && !p.isEmpty()) {
                    temp = p.dequeue();
                    cb.enqueue(temp);
                }
            }

            temp = cb.dequeue();
            for(int i = 0; i < quant; i++) {
                temp.execute();
            }
            if(!temp.isDone()) {
                cb.enqueue(temp);
            } else {
                done.enqueue(temp);
            }
        }
        return done;
    }

    public static void main(String[] args) throws EmptyQueueException, FullQueueException {
        InfiniteQueue<Process> processes = generate(100);

        System.out.println("Procesy wejsciowe:" + processes);
        System.out.println("Procesy wyjsciowe:" + transferProcesses(processes));
    }
}
