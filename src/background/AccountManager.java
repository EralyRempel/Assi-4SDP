package background;

public class AccountManager {
    public boolean verifyIncomeAndAccounts(String passportId, double requestedAmount) {
        System.out.println("[AccountManager] Checking income and passport accounts: " + passportId);
        double monthlyIncome = 450000.0;
        System.out.println("[AccountManager] Confirmed monthly income: " + monthlyIncome + " tg.");

        if (requestedIncomeSufficient(monthlyIncome, requestedAmount)) {
            System.out.println("[AccountManager] The financial situation is stable, there is enough income.");
            return true;
        } else {
            System.out.println("[AccountManager] There is not enough income for the requested loan amount.");
            return false;
        }
    }

    private boolean requestedIncomeSufficient(double income, double amount) {
        return income >= (amount * 0.1);
    }
}