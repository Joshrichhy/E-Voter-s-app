import Controllers.PoliticalPartyController;
import Controllers.VoterController;
import dtos.RegisterRequests;
import dtos.RegisterVoterRequest;

import javax.swing.*;

public class Main {
    private static PoliticalPartyController politicalPartyController = new PoliticalPartyController();
    private static VoterController voterController = new VoterController();
    public static void main(String[] args) {
        startApp();
    }
    private static void startApp() {
        String message = """
                Welcome, make a change with your vote
                pick any Option below;
                1 --> Register Political Party
                 2--> Find Political Party
                 3--> Register Voter
                4--> Search Voters
                5 --> Cast Vote
                 6 --> Display Political Party Results
                 """;
        String input = input(message);
        switch ((input.charAt(0))) {
            case '1' -> registerPoliticalParty();
            case '2' -> findPoliticalParty();
            case '3' -> registerVoter();
            case '4' -> findVoterById();
            case '5' -> castVote();
            case '6' -> displayPoliticalParties();

        }
    }

    private static void displayPoliticalParties() {
    }

    private static void castVote() {

        String userInput = input("Enter Political Party to vote for");
        int voter_id = Integer.parseInt(input("Enter Voter ID"));
        display(voterController.votePoliticalParty(userInput, voter_id));
        startApp();

    }

    private static void findVoterById() {
        String userInput = input("Enter Voter ID to search for");
        display(voterController.findVoterById(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void registerVoter() {
        RegisterVoterRequest request = new RegisterVoterRequest();
        request.setFirstName(input("Enter First Name"));
        request.setLastName(input("Enter Last Name"));
        request.setAge(Integer.parseInt(input("Enter Your Age")));

        var result = voterController.register(request);
        display(result.toString());
        startApp();
    }

    private static void findPoliticalParty() {
        String userInput = input("Enter Political Party to search for");
        display(politicalPartyController.findPoliticalParty(userInput).toString());
        startApp();
    }

    private static void registerPoliticalParty() {
        RegisterRequests request = new RegisterRequests();
        request.setPartyName(input("Enter Political Party Name"));
        request.setPartyLogo(input("Enter Political Party Logo "));
        request.setPartyCandidate(input("Enter Preferred Candidate"));
        var result = politicalPartyController.registerPoliticalParty(request);
        display(result.toString());
        startApp();

    }

    private static String input(String prompt) {
                return JOptionPane.showInputDialog(prompt);
            }

            private static void display(String message){
                JOptionPane.showMessageDialog(null, message);
            }

        }