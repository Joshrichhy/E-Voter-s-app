package Controllers;

import Services.PoliticalPartyService;
import Services.PoliticalServiceImpl;
import dtos.RegisterRequests;

public class PoliticalPartyController {
    private PoliticalPartyService politicalPartyService = new PoliticalServiceImpl();

    public Object registerPoliticalParty(RegisterRequests registerRequests){
        try{
            return politicalPartyService.registerPoliticalParty(registerRequests);
        }catch(NullPointerException | IllegalArgumentException ex){
            return ex.getMessage(); }
    }

    public Object findPoliticalParty(String partyName){
        try {
            return politicalPartyService.findPoliticalParty(partyName);}
        catch (NullPointerException ex){return ex.getMessage();}
    }
}
