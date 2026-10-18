import facade.LoanApplicationFacade;

public class Main {
    public static void main(String[] args) {
        LoanApplicationFacade loanFacade = new LoanApplicationFacade();

        System.out.println("---  1: Successful Application ---");
        boolean success = loanFacade.processLoanApplication("John Doe", "KZ1234567", 1500000.0);

        System.out.println("\n----------------------------------\n");

        System.out.println("---  2: Application from a fraud ---");
        loanFacade.processLoanApplication("Jane Doe", "0009999", 5000000.0);
    }
}