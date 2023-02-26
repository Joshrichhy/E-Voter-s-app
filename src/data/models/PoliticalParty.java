package data.models;

import java.time.LocalDateTime;

public class PoliticalParty {
    private String partyName;
    private String partyCandidate;
    private String partyLogo;
    private int partyId;
    private long numberOfVotes;
    private LocalDateTime dateRegistered = LocalDateTime.now();

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyCandidate() {
        return partyCandidate;
    }

    public void setPartyCandidate(String partyCandidate) {
        this.partyCandidate = partyCandidate;
    }

    public String getPartyLogo() {
        return partyLogo;
    }

    public void setPartyLogo(String partyLogo) {
        this.partyLogo = partyLogo;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public long getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(long numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public LocalDateTime getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDateTime dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "PoliticalParty{" +
                "partyName='" + partyName +"\n" + '\'' +
                ", partyCandidate='" + partyCandidate  +"\n" + '\'' +
                ", partyLogo='" + partyLogo  +"\n" +  '\'' +
                ", partyId=" + partyId +"\n" +
                ", numberOfVotes=" + numberOfVotes +"\n" +
                ", dateRegistered=" + dateRegistered +"\n"+
                '}';
    }
}
