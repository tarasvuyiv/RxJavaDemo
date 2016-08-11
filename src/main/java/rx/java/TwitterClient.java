package rx.java;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

public class TwitterClient {

    public static void main(String[] args) {
        Observable<Tweet> twitter = ServerOne.getData();
        
        ConnectableObservable<Tweet> connectableTwitter = twitter.publish();
        
        connectableTwitter.subscribe(new Subscriber<Tweet>() {
            @Override
            public void onNext(Tweet tweet) {
                System.out.println("Subscriber_1" + " - " + tweet);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println(throwable);
            }

            @Override
            public void onCompleted() {
                System.out.println("*** Стрім завершився ***");
            }
        });
        
        connectableTwitter.subscribe(tweet -> System.out.println("Subscriber_2 - " + tweet));
        
        connectableTwitter.connect();

    }

}
