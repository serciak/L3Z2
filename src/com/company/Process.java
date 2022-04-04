package com.company;

import java.util.Random;

public class Process {

    private boolean isDone;
    private int id;

    public Process(int id) {
        this.id = id;
        isDone = false;
    }

    public String toString() {
        return id + "\tWykonany?: " + isDone;
    }

    public boolean isDone() {
        return isDone;
    }

    public void execute() {
        double probability = 0.25;
        Random rand = new Random();

        if (probability > rand.nextDouble(0, 1))
            isDone = true;
    }
}
