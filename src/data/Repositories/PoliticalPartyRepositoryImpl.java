package data.Repositories;

import data.models.PoliticalParty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PoliticalPartyRepositoryImpl implements PoliticalPartyRepository{

    private int count;
   public static List <PoliticalParty> politicalParties = new ArrayList<>();

    @Override
    public PoliticalParty saveParty(PoliticalParty party) {
        boolean userHasNotBeenSaved = party.getPartyId() == 0;
        if(userHasNotBeenSaved){
            party.setPartyId(generatePartyId());
            politicalParties.add(party);
            count++;
        }
        return party;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public PoliticalParty findbyPartyName(String partyName) {
        for (PoliticalParty politicalParty: politicalParties) {
            if((politicalParty.getPartyName().equalsIgnoreCase( partyName))) return politicalParty;}
           return  null;
        // throw new NullPointerException("Political Party Not Found");
    }

    @Override
    public Long voteParty(String poliiticalParty) {
       PoliticalParty partyToVote =  findbyPartyName(poliiticalParty);
       Long votes = partyToVote.getNumberOfVotes();
       Long newVotes = votes+1;
       partyToVote.setNumberOfVotes(newVotes);
        return newVotes;
    }

    @Override
    public void deletePoliticalParty(String poliiticalParty) {
        PoliticalParty partyToDelete = findbyPartyName(poliiticalParty);
        politicalParties.remove(partyToDelete);
        count--;

    }

    @Override
    public void deleteAllPoliticalParties() {
        politicalParties.clear();
        count = 0;
    }

    @Override
    public List<PoliticalParty> findAllPoliticalParties() {
        return politicalParties;
    }


    private int generatePartyId() {
        return count+1;
    }
}
