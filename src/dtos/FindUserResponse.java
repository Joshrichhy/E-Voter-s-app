package dtos;

import java.time.LocalDateTime;

public class FindUserResponse {

        private String partyName;
        private String partyCandidate;
        private String partyLogo;
        private long numberOfVotes;
        private String dateRegistered;

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

        public long getNumberOfVotes() {
            return numberOfVotes;
        }

        public void setNumberOfVotes(long numberOfVotes) {
            this.numberOfVotes = numberOfVotes;
        }

        public String getDateRegistered() {
            return dateRegistered;
        }

        public void setDateRegistered(String dateRegistered) {
            this.dateRegistered = dateRegistered;
        }

        @Override
        public String toString() {
            return "PoliticalParty{" +
                    "partyName='" + partyName +"\n" + '\'' +
                    ", partyCandidate='" + partyCandidate  +"\n" + '\'' +
                    ", partyLogo='" + partyLogo  +"\n" +  '\'' +
                    ", numberOfVotes=" + numberOfVotes +"\n" +
                    ", dateRegistered=" + dateRegistered +"\n"+
                    '}';
        }
}
