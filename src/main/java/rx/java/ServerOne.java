package rx.java;

import rx.Observable;

public class ServerOne {

    public static Observable<Tweet> getData() {
        System.out.println("*** Дістаю твіти з SERVER_ONE ***");

        return Observable.create(subscriber -> {

            for (Tweet tweet : TweetStore.getTweets()) {
                subscriber.onNext(tweet);

                try {
                    Thread.sleep(500);
                } catch (Throwable e) {
                    subscriber.onError(e);
                }
            }

            subscriber.onCompleted();
        });
    }
}
