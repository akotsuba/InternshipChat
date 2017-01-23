package com.agilie.internship.utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class RxUtils {

    public static void unsubscribeIfNotNull(Subscription subscription) {
        subscription.unsubscribe();
    }

    public static CompositeSubscription getNewCompositeSubIfUnsubscribed(CompositeSubscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            return new CompositeSubscription();
        }
        return subscription;
    }

}
