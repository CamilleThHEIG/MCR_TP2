package mcr;

import mcr.account.Publisher;

/**
 * Interface for objects that receive updates from Publishers
 */
public interface Subscriber {
    /**
     * Should update the subscriber from changes in it's publisher.
     * @param publisher publisher that updates the subscriber
     */
    void update(Publisher publisher);
}
