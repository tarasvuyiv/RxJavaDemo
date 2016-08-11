package rx.java;

import java.util.ArrayList;
import java.util.List;

public class TweetStore {

    private static List<Tweet> tweets = new ArrayList<>();

    static {
        tweets.add(new Tweet("@katyperry", "Я пчихнула."));
        tweets.add(new Tweet("@justinbieber", "Я поколупався в носі."));
        tweets.add(new Tweet("@BarackObama", "А в мене нога свербить."));
        tweets.add(new Tweet("@rihanna", "Хочу їсти."));
        tweets.add(new Tweet("@britneyspears", "Сфоткала, як він хропить."));
        tweets.add(new Tweet("@Cristiano", "Щойно плакав."));
        tweets.add(new Tweet("@BillGates", "П'ю львівське пиво."));
        tweets.add(new Tweet("@BarackObama", "Більше не хочу бути президентом :("));
        tweets.add(new Tweet("@katyperry", "На-на-на Ля-ля-ля."));
        tweets.add(new Tweet("@BarackObama", "Чорні хлопці рушають у ніч!"));
    }

    public static List<Tweet> getTweets() {
        return tweets;
    }
}
