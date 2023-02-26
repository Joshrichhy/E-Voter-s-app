package data.Repositories;

import data.models.Voter;

import java.util.ArrayList;
import java.util.List;

public class VoterRepositoryImpl implements VoterRepository{
    private int count;
    private static List<Voter> voters = new ArrayList<>();

    @Override
    public Voter save(Voter voter) {
        boolean userHasNotBeenSaved = voter.getVotersId() == 0;
        if(userHasNotBeenSaved){
            voter.setVotersId(generateVoterId());
            voters.add(voter);
            count++;}
        return voter;
    }

    private long generateVoterId() {
        return count+1;
    }

    @Override
    public Voter findById(int id) {
        for (Voter voter : voters) if (voter.getVotersId() == id) return voter;
        throw  new NullPointerException("User Id not found");

    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Voter> findAll() {
        return voters;
    }

    @Override
    public void delete(Voter voter) {
        for (Voter eachVoter : voters) {
            if(eachVoter == voter) {voters.remove(voters);
                count--; break;}}
    }

    @Override
    public void delete(int id) {
        for (Voter voter : voters) {
            if(voter.getVotersId() == id) {
                voters.remove(voter);
                count--;
                break;}}
    }

    @Override
    public void deleteAll() {
        voters.clear();
        count = 0;    }

}
