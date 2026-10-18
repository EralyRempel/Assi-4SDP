package facade;

import background.AccountManager;
import background.ContractGenerator;
import background.CreditScoreVerifier;
import background.FraudDetector;

public class LoanApplicationFacade {
    private final FraudDetector fraudDetector;
    private final CreditScoreVerifier creditScoreVerifier;
    private final AccountManager accountManager;
    private final ContractGenerator contractGenerator;

    public LoanApplicationFacade() {
        this.fraudDetector = new FraudDetector();
        this.creditScoreVerifier = new CreditScoreVerifier();
        this.accountManager = new AccountManager();
        this.contractGenerator = new ContractGenerator();
    }


    public boolean processLoanApplication(String clientName, String passportId, double requestedAmount) {
        System.out.println("=== The beginning of the processing of the loan application through the Facade ===");


        boolean isSafe = fraudDetector.checkClient(clientName, passportId);
        if (!isSafe) {
            System.out.println("The application was rejected by the security service.");
            return false;
        }


        int score = creditScoreVerifier.getCreditScore(passportId);
        if (!creditScoreVerifier.isScoreSufficient(score)) {
            System.out.println("The application was rejected: low credit rating.");
            return false;
        }


        boolean isSolvent = accountManager.verifyIncomeAndAccounts(passportId, requestedAmount);
        if (!isSolvent) {
            System.out.println("The application was rejected: insufficient funds/income.");
            return false;
        }


        String contract = contractGenerator.generateContract(clientName, requestedAmount);
        System.out.println("Congratulations! The loan has been successfully approved. Contract number:" + contract);

        return true;
    }
}
