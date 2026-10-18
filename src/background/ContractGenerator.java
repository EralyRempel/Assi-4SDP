package background;

public class ContractGenerator {
    public String generateContract(String clientName, double amount) {
        System.out.println("[ContractGenerator] Generating an official loan agreement");
        String contractId = "CONTRACT-" + System.currentTimeMillis();
        System.out.println("[ContractGenerator]  Contract #" + contractId + " successfully formed for " + clientName + " for amount " + amount + " tg.");
        return contractId;
    }
}
