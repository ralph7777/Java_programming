import java.util.Scanner;

/**
   This is test driver for BankAccount.
   Following program simulates a bank with both checking and savings accounts.
*/

public class AccountDemo{

	public static void main(String[] args){
	
		// Create accounts
		final int ACCOUNTS_SIZE = 10;
		BankAccount[] accounts = new BankAccount[ACCOUNTS_SIZE];
		for (int i = 0; i < accounts.length / 2; i++){      
			accounts[i] = new CheckingAccount();
		}
      
		for (int i = accounts.length / 2; i < accounts.length; i++){      
			SavingsAccount account = new SavingsAccount();
			account.setInterestRate(0.75);
			accounts[i] = account;
		}


		// Execute commands
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done){
			System.out.print("D)Deposit  W)Withdraw  M)Month end  Q)Quit: "); 
			String input = in.next();
	
		// Deposit or withdrawal
		if (input.equals("D") || input.equals("W")) {
			System.out.print("Enter account number and amount: ");
			int num = in.nextInt();
			double amount = in.nextDouble();

			if (input.equals("D")) { accounts[num].deposit(amount); }
			else { accounts[num].withdraw(amount); }

			System.out.println("Balance: " + accounts[num].getBalance());
			}
		// Month
		else if (input.equals("M")){

			for (int n = 0; n < accounts.length; n++){
				accounts[n].monthEnd();
				System.out.println(n + " " + accounts[n].getBalance());
				}
			}
		else if (input.equals("Q")){
           	 done = true;
        		}

      		}
   	}
}