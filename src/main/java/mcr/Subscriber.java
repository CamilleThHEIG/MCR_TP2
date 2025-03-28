package mcr;

import mcr.account.Publisher;

public interface Subscriber {
    /**
     * Should update the subscriber from changes in it's publisher.
     * @param publisher publisher that updates the subscriber   // TODO are we really supposed to specify the publisher?
     */
    void update(Publisher publisher);
}
