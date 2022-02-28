package core;

import java.util.ArrayList;
import java.util.Date;

public class Claim{
    public String text;
    public ArrayList<ClaimReview> claimReview;
    public String claimant;
    public Date claimDate;

    @Override
    public String toString() {
        return "Claim{" +
                "text='" + text + '\'' +
                ", claimReview=" + claimReview +
                ", claimant='" + claimant + '\'' +
                ", claimDate=" + claimDate +
                '}';
    }
}