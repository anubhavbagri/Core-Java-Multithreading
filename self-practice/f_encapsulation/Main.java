package f_encapsulation;

class BankAccount{
    private String accountNum;
    private double balance;

    public BankAccount(String accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNum;
    }

    public double getBalance(){
        return balance;
    }

    // setter method ensuring data validation before updating value
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }
}

public class Main {
    public static void main(String[] args){
        BankAccount account = new BankAccount("12345", 1000.0);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(500.00);
        System.out.println("Updated Balance: " + account.getBalance());
        account.withdraw(200.00);
        System.out.println("Final Balance: " + account.getBalance());
    }
}
