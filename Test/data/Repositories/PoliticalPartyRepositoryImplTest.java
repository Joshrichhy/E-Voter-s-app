package data.Repositories;

import data.models.PoliticalParty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliticalPartyRepositoryImplTest {
    PoliticalPartyRepository politicalPartyRepository;
    PoliticalParty party;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        politicalPartyRepository = new PoliticalPartyRepositoryImpl();
        party = new PoliticalParty();
        party.setPartyName("Labour Party");
        party.setPartyCandidate("Peter Obi");
        party.setPartyLogo("Father, Mother and Child");
    }
    @Test
    public void saveOnePoliticalParty_partyIdIsNotZero(){
        PoliticalParty newParty = politicalPartyRepository.saveParty(party);
        assertEquals(0, newParty.getPartyId());
    }
    @Test
    public void saveOnePoliticalParty_votesIsNotZero(){
        PoliticalParty newParty = politicalPartyRepository.saveParty(party);
        assertEquals(0,newParty.getNumberOfVotes());
    }
    @Test
    public void saveOnePoliticalParty_EditParty_IdIssame(){
        PoliticalParty newParty = politicalPartyRepository.saveParty(party);
        newParty.setPartyName("PDP");
        PoliticalParty editedParty = politicalPartyRepository.saveParty(party);
        assertEquals(1, editedParty.getPartyId());
    }

    @Test
    public void saveTwoPoliticalParty_countIsTwo(){
        politicalPartyRepository.saveParty(party);
        PoliticalParty newParty2 = new PoliticalParty();
        newParty2.setPartyName("APC");
        politicalPartyRepository.saveParty(newParty2);
        assertEquals(2, politicalPartyRepository.count());
    }
    @Test
    public void saveTwoPoliticalParty_findbyPartyName(){
        politicalPartyRepository.saveParty(party);
        PoliticalParty newParty2 = new PoliticalParty();
        newParty2.setPartyName("APC");
        politicalPartyRepository.saveParty(newParty2);
        assertEquals(newParty2, politicalPartyRepository.findbyPartyName("ApC"));
    }
    @Test
    public void saveOnePoliticalParty_findbyWrongPartyNameThrowException(){
        politicalPartyRepository.saveParty(party);
        assertThrows(NullPointerException.class, ()-> politicalPartyRepository.findbyPartyName("apc"));
    }
    @Test
    public void saveOnePoliticalParty_voteParty(){
        PoliticalParty newParty = politicalPartyRepository.saveParty(party);
       Long votes = politicalPartyRepository.voteParty("Labour Party");
        assertEquals(1, newParty.getNumberOfVotes());
    }
    @Test
    public void saveTwoPoliticalParty_voteOnePartyTwice_SecondPartyIsZero(){
        PoliticalParty newParty = politicalPartyRepository.saveParty(party);
        PoliticalParty newParty2 = new PoliticalParty();
        newParty2.setPartyName("APC");
        politicalPartyRepository.voteParty("Labour Party");
       politicalPartyRepository.voteParty("Labour Party");
        assertEquals(2, newParty.getNumberOfVotes());
        assertEquals(0, newParty2.getNumberOfVotes());
    }
    @Test
    public void saveTwoPoliticalParty_deleteOnebyPartName(){
        PoliticalParty newParty = politicalPartyRepository.saveParty(party);
        PoliticalParty newParty2 = new PoliticalParty();
        newParty2.setPartyName("APC");
        politicalPartyRepository.saveParty(newParty2);
        politicalPartyRepository.deletePoliticalParty("APC");
        assertEquals(1, politicalPartyRepository.count());
    }

    @Test
    public void saveTwoPoliticalParty_deleteAll(){
        PoliticalParty newParty = politicalPartyRepository.saveParty(party);
        PoliticalParty newParty2 = new PoliticalParty();
        newParty2.setPartyName("APC");
        politicalPartyRepository.saveParty(newParty2);
        politicalPartyRepository.deleteAllPoliticalParties();
        assertEquals(0, politicalPartyRepository.count());
        assertThrows(NullPointerException.class, ()-> politicalPartyRepository.findbyPartyName("apc"));

    }
}