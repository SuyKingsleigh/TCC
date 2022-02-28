package core;

import java.util.Date;

public class ClaimReview {
    public Publisher publisher;
    public String url;
    public String title;
    public Date reviewDate;
    public String textualRating;
    public String languageCode;

    @Override
    public String toString() {
        return "ClaimReview{" +
                "publisher=" + publisher +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", reviewDate=" + reviewDate +
                ", textualRating='" + textualRating + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}