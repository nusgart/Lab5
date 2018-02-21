/**
 * Class implementing a bank account.
 * Auditing not implemented.
 * <p>
 * Complete and document this class as part of Lab 8.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/8/">Lab 8 Description</a>
 */
@SuppressWarnings("checkstyle:publicvariables")
public class BankAccount {
    /**
     * The account id counter.
     */
    private static int accountsCounter = 0;
    /**
     * account number.
     */
    private final int accountNumber;
    /**
     * the Account Type.
     */
    private BankAccountType accountType;
    /**
     * account balance.
     */
    private double accountBalance;
    /**
     * owner name.
     */
    private String ownerName;
    /**
     * The Account's current interest Rate.
     */
    private double interestRate;
    /**
     * interest earned.
     */
    private double interestEarned;

    /**
     * Make a bank account.
     *
     * @param name            the name.
     * @param accountCategory the category.
     */
    public BankAccount(final String name, final BankAccountType accountCategory) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Null name provided.");
        }
        accountNumber = accountsCounter++;
        this.ownerName = name;
        this.setAccountType(accountCategory);
        accountBalance = 0;
        interestRate = 0; // replace with real default
    }

    /**
     * @return the current number of accounts opened.
     */
    public static int numberOfAccountsOpened() {
        return accountsCounter;
    }

    /**
     * account type.
     *
     * @return the account type.
     */
    public BankAccountType getAccountType() {
        return accountType;
    }

    /**
     * Set account type.
     *
     * @param type account type.
     */
    public void setAccountType(final BankAccountType type) {
        this.accountType = type;
    }

    /**
     * interest rate.
     *
     * @return the interest rate.
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Set interest rate.
     *
     * @param ir interest Rate.
     */
    public void setInterestRate(final double ir) {
        if (ir <= 0 || !Double.isFinite(ir)) {
            final String s = "Account Interest Rate must be a POSITIVE FINITE NUMBER";
            throw new IllegalArgumentException(s);
        }
        this.interestRate = ir;
    }

    /**
     * Get the account number.
     *
     * @return the account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Get the current account balance.
     *
     * @return the current account balance.
     */
    public double getAccountBalance() {
        return accountBalance;
    }
    /* *@param number The new account number.* /
    public void setAccountNumber(final int number) {
        this.accountNumber = number;
    }*/

    /**
     * Set the account's current balance.
     *
     * @param balance the new balance.
     */
    public void setAccountBalance(final double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Overdrawn!");
        }
        this.accountBalance = balance;
    }

    /**
     * Return the owner name.
     *
     * @return the owner name.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Set owner name.
     *
     * @param name new owner name -- must have at least one nonspace character!
     */
    public void setOwnerName(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Account Owner must have a name!");
        }
        this.ownerName = name;
    }

    /**
     * Gets the current amount of earned interest.
     *
     * @return the current amount of earned interest.
     */
    public double getInterestEarned() {
        return interestEarned;
    }

    /**
     * Set the amount of interest earned.
     *
     * @param ie the amount of interest earned.
     */
    public void setInterestEarned(final double ie) {
        if (ie < 0 || !Double.isFinite(ie)) {
            final String s = "Interest Earned must be a NON-NEGATIVE FINITE NUMBER!";
            throw new IllegalArgumentException(s);
        }
        this.interestEarned = ie;
    }

    /**
     * Distinguishes between different kinds of accounts.
     */
    public enum BankAccountType {
        /** A checking account. */
        CHECKINGS,
        /** A savings account. */
        SAVINGS,
        /** A student account. */
        STUDENT,
        /** A workplace account. */
        WORKPLACE
    }
}
