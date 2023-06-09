package data.Repositories;

import data.models.PoliticalParty;

import java.util.List;

public interface PoliticalPartyRepository {
    PoliticalParty saveParty(PoliticalParty party);

    int count();

    PoliticalParty findbyPartyName(String partyName);

    void deletePoliticalParty(String poliiticalParty);
    void deleteAllPoliticalParties();

    List <PoliticalParty> findAllPoliticalParties();

}

