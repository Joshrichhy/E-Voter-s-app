package Services;

import data.models.PoliticalParty;
import dtos.FindPoliticalPartyResponse;
import dtos.RegisterRequests;

public interface PoliticalPartyService {

    PoliticalParty registerPoliticalParty(RegisterRequests registerRequests);
    FindPoliticalPartyResponse findPoliticalParty(String partyName);

    Long votePoliticalParty(String partyName);


}

