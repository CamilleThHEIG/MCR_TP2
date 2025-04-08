package mcr;

import mcr.account.Publisher;

public interface Subscriber {
    /**
     * Should update the subscriber from changes in it's publisher.
     * @param publisher publisher that updates the subscriber
     */
    void update(Publisher publisher);
}
