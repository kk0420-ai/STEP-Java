// File: VotingSystem.java
public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            boolean validate() {
                return voterId != null && voterId.startsWith("V") && voterId.length() == 5;
            }
        }

        VoteValidator validator = new VoteValidator();
        if (validator.validate()) {
            System.out.println("Vote from " + voterId + " accepted for " + candidate);
        } else {
            System.out.println("Invalid Voter ID: " + voterId);
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.processVote("V1234", "Alice");
        vs.processVote("12345", "Bob");
    }
}
