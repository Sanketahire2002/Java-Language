import java.util.Scanner;
import BanksInterface.BanksInterface;
import BankException.InsufficientFundException.InsufficientFundException;
import BankException.InvalidAmountException.InvalidAmountException;
import NameBanks.*;

class AccountUser
{
	public static void main(String[] args) throws InvalidAmountException,InsufficientFundException,NumberFormatException
	{
		int choice = 0;
		double amount = 0;
		Scanner sc = new Scanner(System.in);
		
		BanksInterface ac1 = new KotakBank();	
		
		
		do{
			System.out.println("1. Deposit Amount.");
			System.out.println("2. Withdraw Amount.");
			System.out.println("3. Check Balance.");
			System.out.println("0. Exit.");
			System.out.print("Enter your choice : ");
			
			try
			{
				choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:	System.out.print("Enter Amount to Deposit : ");
							amount = sc.nextDouble();
							ac1.deposit(amount);
							ac1.checkBalance();
							break;
						
					case 2:	System.out.print("Enter Amount to Withdraw : ");
							ac1.withdraw(sc.nextDouble());
							ac1.checkBalance();
							break;
				
					case 3:	ac1.checkBalance();
							break;
				
					case 0: System.exit(0);
							break;
				
					default:System.out.println("Enter Valid Choice.");
							break;
				}
			}
			catch(InsufficientFundException ife)
			{
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
				ife.printStackTrace();
				System.out.println(ife.toString());
				System.out.println(ife.getMessage());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			catch(InvalidAmountException iae)
			{
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
				iae.printStackTrace();
				System.out.println(iae.toString());
				System.out.println(iae.getMessage());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
				nfe.printStackTrace();
				System.out.println(nfe.toString());
				System.out.println(nfe.getMessage());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			catch(Exception e)
			{
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
				e.printStackTrace();
				System.out.println(e.toString());
				System.out.println(e.getMessage());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			
		}while(choice != 0);
	}
}