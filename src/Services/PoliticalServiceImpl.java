package Services;

import data.Repositories.PoliticalPartyRepository;
import data.Repositories.PoliticalPartyRepositoryImpl;
import data.models.PoliticalParty;
import dtos.FindUserResponse;
import dtos.RegisterRequests;
import utils.Mapper;

public class PoliticalServiceImpl implements PoliticalPartyService{
    PoliticalPartyRepository politicalPartyRepository = new PoliticalPartyRepositoryImpl();

    public PoliticalParty registerPoliticalParty(RegisterRequests registerRequest){
        if (userExist(registerRequest.getPartyName())) throw new IllegalArgumentException(registerRequest.getPartyName() + " already exists");
        return politicalPartyRepository.saveParty(Mapper.map(registerRequest));

    }

    @Override
    public FindUserResponse findPoliticalParty(String partyName) {
        PoliticalParty foundUser =  politicalPartyRepository.findbyPartyName(partyName);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }

    @Override
    public Long votePoliticalParty(String partyName) {
        return politicalPartyRepository.voteParty(partyName);
    }

    private boolean userExist(String partyName) {
        PoliticalParty foundParty = politicalPartyRepository.findbyPartyName(partyName);
        if (foundParty != null) return true;
        return false;
    }
}
