package Services;

import data.models.Voter;
import dtos.FindVoterResponse;
import dtos.RegisterVoterRequest;

import java.util.List;

public interface VoterServices {
    Voter registerVoter(RegisterVoterRequest registerRequest);

    FindVoterResponse findVoter(int id);

    List<Voter> findAll();
    void delete(Voter user);
    void delete(int id);
    void deleteAll();
    String votePoliticalParty(String partyName, int id);
}
