package rx.java.schedulers;

import rx.Observable;
import rx.java.Tweet;
import rx.java.TweetStore;
import rx.schedulers.Schedulers;

public class SubscribeOnObserveOn {

    public static void main(String[] args) {

        Observable<Tweet> observableTweets = Observable.from(TweetStore.getTweets());

        observableTweets.subscribeOn(Schedulers.computation()).doOnNext(tweet -> log(tweet))
                .observeOn(Schedulers.io()).subscribe(tweet -> handleTweet(tweet));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void handleTweet(Tweet tweet) {
        try {
            System.out.println("** Обробка " + tweet + " на " + Thread.currentThread().getName());

            Thread.sleep((int) (Math.random() * 500));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void log(Tweet tweet) {
        System.out.println("===> LOG " + tweet + " на " + Thread.currentThread().getName());
    }

}
