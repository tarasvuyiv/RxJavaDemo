package rx.java;

public class Tweet {

    private String author;
    private String message;

    public Tweet(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return author + ": " + message;
    }

}
