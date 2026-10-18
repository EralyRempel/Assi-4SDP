package background;

public class FraudDetector {
    public boolean checkClient(String clientName, String passportId) {
        System.out.println("[FraudDetector] Client check " + clientName + " (Passport: " + passportId + ") in fraud lists");

        if (clientName.toLowerCase().contains("Fraud") || passportId.startsWith("000")) {
            System.out.println("[FraudDetector]  There is a match");
            return false;
        }
        System.out.println("[FraudDetector] Check is completed successfully");
        return true;
    }
}
