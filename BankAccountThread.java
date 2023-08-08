/****************************************************************************
* David Daniel
* CS149
* August 3rd, 2023
*
* Abstract: This is the BankAccountThread Class. The deposit functionality and the withdraw functionality is handled using threads.
*
***************************************************************************/

public class BankAccountThread {
    private double accountBalance;

    //initializes the bank account with inputed balance
    public BankAccountThread(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    // takes in and adds amount to current balance, and prints out the statement
    public synchronized void depositAmount(double amount) {
        accountBalance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", new balance: " + accountBalance);
    }

    //withdraws amount from total balance, and prints out statement
    public synchronized void withdrawAmount(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", new balance: " + accountBalance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }

    //returns account balance
    public synchronized double getAccountBalance() {
        return accountBalance;
    }
}
