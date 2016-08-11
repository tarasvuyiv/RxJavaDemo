package rx.java.schedulers;

import rx.Observable;
import rx.java.Tweet;
import rx.java.TweetStore;
import rx.schedulers.Schedulers;

public class ParallelStreams {

    public static void main(String[] args) {
        Observable<Tweet> observableTweet = Observable.from(TweetStore.getTweets());

        observableTweet
                .flatMap(tweet -> Observable.just(tweet).subscribeOn(Schedulers.computation())
                        .map(t -> transformTweet(t)))
                .subscribe(tweet -> System.out.println(
                        "Отримали: " + tweet + " на  " + Thread.currentThread().getName()));
        try {
            Thread.sleep(5000);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static Tweet transformTweet(Tweet tweet) {
        try {
            System.out.println(
                    "** Трансформуємо твіт " + tweet + " на " + Thread.currentThread().getName());
            Thread.sleep((int) (Math.random() * 500));
            return new Tweet(tweet.getAuthor(), tweet.getMessage().replace(" ", "").toLowerCase());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
}
