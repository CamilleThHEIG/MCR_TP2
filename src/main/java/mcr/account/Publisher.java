package mcr.account;

import mcr.Subscriber;

public interface Publisher {
    /**
     * Should subscribe a given subscriber to the Publisher
     * @param subscriber the subscriber to subscriber
     */
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);

    /**
     * Should notify every publisher's subscribers from changes in the publisher.
     */
    void notifySubscribers();
}
