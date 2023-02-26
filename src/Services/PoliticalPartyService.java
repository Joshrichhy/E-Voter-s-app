package Services;

import data.models.PoliticalParty;
import dtos.FindUserResponse;
import dtos.RegisterRequests;

public interface PoliticalPartyService {

    PoliticalParty registerPoliticalParty(RegisterRequests registerRequests);
    FindUserResponse findPoliticalParty(String partyName);

    Long votePoliticalParty(String partyName);


}

