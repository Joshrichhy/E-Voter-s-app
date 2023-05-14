package Services;

import data.Repositories.VoterRepository;
import data.Repositories.VoterRepositoryImpl;
import data.models.Voter;
import dtos.FindVoterResponse;
import dtos.RegisterVoterRequest;
import utils.Mapper;

import java.util.List;

public class VoterServicesImpl implements VoterServices{
    VoterRepository voterRepository = new VoterRepositoryImpl();
    PoliticalPartyService politicalPartyService = new PoliticalServiceImpl();

    @Override
    public Voter registerVoter(RegisterVoterRequest registerRequest) {
       if(registerRequest.getAge() < 18) throw new IllegalArgumentException("Age not eligible to vote, you must be over 18+");
       if (userExist(registerRequest.getUserName())) throw new IllegalArgumentException(registerRequest.getUserName() + "already exist");
       return voterRepository.save(Mapper.map(registerRequest));
    }
    private boolean userExist(String userName) {
        Voter found = voterRepository.findByUserName(userName);
        return found != null;
    }

    @Override
    public FindVoterResponse findVoter(int id) {
        Voter voter = voterRepository.findById(id);
        if(voter == null) throw new NullPointerException("Voter not found");
        FindVoterResponse response = new FindVoterResponse();
        Mapper.map(voter, response);
        return response;
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
        FindVoterResponse voter = findVoter(id);
        if (voter != null) {politicalPartyService.votePoliticalParty(partyName);
        return "You have successfully voted for your preferred Political Party, Good job";}
  else throw new IllegalArgumentException ("Voter Not Registered");}


}
