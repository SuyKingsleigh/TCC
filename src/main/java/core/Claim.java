package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Claim {
    public String text;
    public ArrayList<ClaimReview> claimReview;
    public String claimant;
    public Date claimDate;


    private static String prettyClaimFromClaimReview(Claim claim, ClaimReview review) {
        return "De acordo com " + review.publisher.name + " \"" + claim.text + "\" é" + "\"" + review.textualRating
                + "\" veja mais em: " + review.url;
    }

    public static List<String> prettyClaim(Claim claim) {
        List<String> reviews = new LinkedList<>();
        for (ClaimReview review : claim.claimReview)
            reviews.add(prettyClaimFromClaimReview(claim, review));
        return reviews;
    }

}