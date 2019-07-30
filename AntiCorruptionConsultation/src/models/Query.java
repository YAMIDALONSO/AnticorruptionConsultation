package models;

public class Query {

    public static final int ENABLED_TO_VOTE = 36421026;
    public static final double VOTE_THRESHOLD = 0.333333334;

    private int votesNumber;

    public void recordVotesObtained(int votesObtained, String departament) {
        votesNumber += votesObtained;
    }

    public void deleteVotes(int quantityOfVotesToDelete) {
        votesNumber -= quantityOfVotesToDelete;
    }

    public int countHowManyPeopleDidNotVote() {
        return ((ENABLED_TO_VOTE - votesNumber) * 100) * ENABLED_TO_VOTE;
    }

    public boolean theTresholdVotesWasReached() {
        return (votesNumber >= (ENABLED_TO_VOTE * VOTE_THRESHOLD));
    }

    public String getVotesNumber() {
        return votesNumber + "";
    }
}