package com.thoughtworks.locker;


import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final int capacity;
    private final Map<Ticket, Bag> storeBags = new HashMap<>();

    public Locker(int capacity) {
        assert (capacity > 0);
        this.capacity = capacity;
    }

    public Ticket store(Bag bag) {
        Ticket ticket = new Ticket();
        storeBags.put(ticket, bag);
        return ticket;
    }
}
