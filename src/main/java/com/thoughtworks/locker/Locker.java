package com.thoughtworks.locker;


import com.thoughtworks.locker.exception.FullException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Locker {
    private final AtomicInteger availableCapacity;
    private final Map<Ticket, Bag> storeBags = new HashMap<>();

    public Locker(int capacity) {
        assert (capacity > 0);
        this.availableCapacity = new AtomicInteger(capacity);
    }

    public Ticket store(Bag bag) {
        if (availableCapacity.get() == 0) {
            throw new FullException();
        }
        availableCapacity.decrementAndGet();
        Ticket ticket = new Ticket();
        storeBags.put(ticket, bag);
        return ticket;
    }

    public Bag retrieval(Ticket ticket) {
        Bag bag = storeBags.get(ticket);
        if (bag != null) {
            storeBags.remove(ticket);
            availableCapacity.incrementAndGet();
        }
        return bag;
    }
}
