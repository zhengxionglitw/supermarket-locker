package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.FullException;
import com.thoughtworks.locker.exception.InvalidTicketException;
import org.junit.Assert;
import org.junit.Test;

public class LockerTest {

    @Test(expected = AssertionError.class)
    public void should_throw_assert_exception_when_init_locker_given_capacity_is_0() {
        new Locker(0);
    }

    @Test(expected = AssertionError.class)
    public void should_throw_assert_exception_when_init_locker_given_capacity_lt_0() {
        new Locker(0);
    }

    @Test
    public void should_success_when_init_locker_given_capacity_gt_0() {
        new Locker(1);
    }

    @Test
    public void should_store_bag_successful_when_store_bag_given_locker_has_available_capacity() {
        Locker locker = new Locker(2);

        Ticket ticket = locker.store(new Bag());

        Assert.assertNotNull(ticket);
    }

    @Test(expected = FullException.class)
    public void should_store_failed_when_store_bag_given_locker_has_no_available_capacity() {
        Locker locker = new Locker(1);
        locker.store(new Bag());

        locker.store(new Bag());
    }

    @Test
    public void should_retrieval_successful_when_retrieval_bag_given_a_valid_ticket() {
        Locker locker = new Locker(2);
        Bag bag = new Bag();
        Ticket ticket = locker.store(bag);

        Bag retrievalBag = locker.retrieval(ticket);

        Assert.assertNotNull(retrievalBag);
        Assert.assertEquals(bag, retrievalBag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_retrieval_fail_when_retrieval_bag_given_a_invalid_ticket() {
        Locker locker = new Locker(1);

        locker.retrieval(new Ticket());
    }
}
