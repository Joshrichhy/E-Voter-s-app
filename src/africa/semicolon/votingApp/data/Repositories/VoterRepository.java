package data.Repositories;

import data.models.Voter;

import java.util.List;

public interface VoterRepository {
    Voter save(Voter voter);
    Voter findById(int id);
    long count();
    List<Voter> findAll();
    void delete(Voter user);
    void delete(int id);
    void deleteAll();

    Voter findByUserName(String userName);
}
