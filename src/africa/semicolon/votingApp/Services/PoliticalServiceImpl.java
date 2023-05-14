package Services;

import data.Repositories.PoliticalPartyRepository;
import data.Repositories.PoliticalPartyRepositoryImpl;
import data.models.PoliticalParty;
import dtos.FindPoliticalPartyResponse;
import dtos.RegisterRequests;
import utils.Mapper;

public class PoliticalServiceImpl implements PoliticalPartyService{
   private static PoliticalPartyRepository politicalPartyRepository = new PoliticalPartyRepositoryImpl();

    public PoliticalParty registerPoliticalParty(RegisterRequests registerRequest){
        if (userExist(registerRequest.getPartyName())) throw new IllegalArgumentException(registerRequest.getPartyName() + " already exists");
        return politicalPartyRepository.saveParty(Mapper.map(registerRequest));

    }

    @Override
    public FindPoliticalPartyResponse findPoliticalParty(String partyName) {
        PoliticalParty foundUser =  politicalPartyRepository.findbyPartyName(partyName);
        if(foundUser != null){
        FindPoliticalPartyResponse response = new FindPoliticalPartyResponse();
        Mapper.map(foundUser, response);
        return response;}
        throw new NullPointerException("Political Party not found");
    }

    private boolean userExist(String partyName) {
        PoliticalParty foundParty = politicalPartyRepository.findbyPartyName(partyName);
        if (foundParty != null) return true;
        return false;
    }
    public Long votePoliticalParty(String poliiticalParty) {
        PoliticalParty partyToVote =  politicalPartyRepository.findbyPartyName(poliiticalParty);
        Long votes = partyToVote.getNumberOfVotes() + 1;
        partyToVote.setNumberOfVotes(votes);
        return votes;
    }
}
