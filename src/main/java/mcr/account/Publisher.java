package mcr.account;

import mcr.Subscriber;

/**
 * Interface for objects that notify subscribers of changes.
 */
public interface Publisher {
    /**
     * Should subscribe a given subscriber to the Publisher
     * @param subscriber the subscriber to subscriber
     */
    void subscribe(Subscriber subscriber);

    /**
     * Should unsubscribe a subscriber to the publisher
     * @param subscriber the subscriber to update
     */
    void unsubscribe(Subscriber subscriber);

    /**
     * Should notify every publisher's subscribers from changes in the publisher.
     */
    void notifySubscribers();
}
