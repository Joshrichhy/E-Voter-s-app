package Services;

import data.Repositories.VoterRepository;
import data.Repositories.VoterRepositoryImpl;
import data.models.Voter;
import dtos.RegisterVoterRequest;
import utils.Mapper;

import java.util.List;

public class VoterServicesImpl implements VoterServices{
    VoterRepository voterRepository = new VoterRepositoryImpl();
    PoliticalPartyService politicalPartyService = new PoliticalServiceImpl();

    @Override
    public Voter registerVoter(RegisterVoterRequest registerRequest) {
        return voterRepository.save(Mapper.map(registerRequest));

    }

    @Override
    public Voter findVoter(int id) {
        return voterRepository.findById(id);
    }

    @Override
    public List<Voter> findAll() {
        return voterRepository.findAll();
    }

    @Override
    public void delete(Voter voter) {
        voterRepository.delete(voter);
    }

    @Override
    public void delete(int id) {
        voterRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        voterRepository.deleteAll(); }

    @Override
    public String votePoliticalParty(String partyName, int id) {
        Voter voter = findVoter(id);
        if (voter != null) {politicalPartyService.votePoliticalParty(partyName);
        return "Good job";}
  else throw new IllegalArgumentException ("Not Registered");}
}
