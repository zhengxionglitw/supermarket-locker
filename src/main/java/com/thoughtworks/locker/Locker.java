package com.thoughtworks.locker;

public class Locker {
    private final int capacity;

    public Locker(int capacity) {
        assert (capacity > 0);
        this.capacity = capacity;
    }
}
