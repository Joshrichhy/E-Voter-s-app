package dtos;

public class RegisterRequests {
        private String partyName;
        private String partyCandidate;
        private String partyLogo;


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


        @Override
        public String toString() {
            return "PoliticalParty{" +
                    "partyName='" + partyName +"\n" + '\'' +
                    ", partyCandidate='" + partyCandidate  +"\n" + '\'' +
                    ", partyLogo='" + partyLogo  +"\n" +  '\'' +
                    '}';

    }

}
