package Controllers;

import Services.VoterServices;
import Services.VoterServicesImpl;
import dtos.RegisterVoterRequest;

public class VoterController {
    private VoterServices voterServices = new VoterServicesImpl();
    public Object register(RegisterVoterRequest request){
        try{
            return voterServices.registerVoter(request);
        }
        catch (IllegalArgumentException ex){
            return ex.getMessage();}
    }

    public Object findVoterById(int id) {
        try {
            return voterServices.findVoter(id);
        } catch (NullPointerException ex) {
            return  ex.getMessage();}
    }
    public String votePoliticalParty(String partyName, int id){
        try{
      return  voterServices.votePoliticalParty(partyName, id);}
        catch(IllegalArgumentException | NullPointerException ex){
          return  ex.getMessage();
        }
    }
}
