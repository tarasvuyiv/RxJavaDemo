package rx.java;

import rx.Observable;

public class ServerTwo {

    public static Observable<Tweet> getData() {
        System.out.println("*** Дістаю твіти з SERVER_TWO ***");

        return Observable.create(observer -> {

            for (Tweet tweet : TweetStore.getTweets()) {
                observer.onNext(tweet);
                try {
                    Thread.sleep(500);
                } catch (Throwable e) {
                    observer.onError(e);
                }
            }

            observer.onCompleted();
        });
    }
}
