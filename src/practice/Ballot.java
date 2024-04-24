package practice;

import java.util.List;


public class Ballot {
    public Ballot(final List<String> voters) {
        this.voters = voters;
    }

    public List<String> getVoters() {
        return voters;
    }

    public void setVoters(final List<String> voters) {
        this.voters = voters;
    }

    List<String> voters;
}
