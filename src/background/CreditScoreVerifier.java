package background;

public class CreditScoreVerifier {
    public int getCreditScore(String passportId) {
        System.out.println("[CreditScoreVerifier] Credit history request: " + passportId);
        int score = 720;
        System.out.println("[CreditScoreVerifier] Client Rating: " + score + " pts.");
        return score;
    }

    public boolean isScoreSufficient(int score) {
        return score >= 600;
    }
}
