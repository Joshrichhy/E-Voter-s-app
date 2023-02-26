package utils;

import data.models.PoliticalParty;
import data.models.Voter;
import dtos.FindUserResponse;
import dtos.RegisterRequests;
import dtos.RegisterVoterRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static PoliticalParty map(RegisterRequests registerRequest){
        PoliticalParty party = new PoliticalParty();
        party.setPartyName(registerRequest.getPartyName());
        party.setPartyCandidate(registerRequest.getPartyCandidate());
        party.setPartyLogo(registerRequest.getPartyLogo());
        return party;
    }

    public static void map( PoliticalParty party, FindUserResponse userResponse){
        userResponse.setPartyName(party.getPartyName());
        userResponse.setPartyCandidate(party.getPartyCandidate());
        userResponse.setPartyLogo(party.getPartyLogo());
        userResponse.setNumberOfVotes(party.getNumberOfVotes());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        userResponse.setDateRegistered((formatter.format(party.getDateRegistered())));
    }

    public static Voter map(RegisterVoterRequest registerRequest){
        Voter voter = new Voter();
        voter.setFirstName(registerRequest.getFirstName());
        voter.setLastName(registerRequest.getLastName());
        voter.setAge(registerRequest.getAge());
        voter.setVotersId(registerRequest.getVotersId());
        return voter;
    }
}
