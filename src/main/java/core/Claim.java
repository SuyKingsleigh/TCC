package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Claim {
    public String text;
    public ArrayList<ClaimReview> claimReview;
    public String claimant;
    public Date claimDate;

    public static String prettyClaim(Claim claim) {
        return claim.text +
                (claim.claimant != null && !claim.claimant.isEmpty() ? " de acordo com '" + claim.claimant + "'" : "") +
                "\nVocê pode verificar mais em: "
                + claim.claimReview.stream().map(ClaimReview::getUrl).collect(Collectors.joining("\n"));
    }

}