package NameBanks;

import BanksInterface.BanksInterface;
import BankException.InsufficientFundException.InsufficientFundException;
import BankException.InvalidAmountException.InvalidAmountException;

public class HDFCBank implements BanksInterface
{
	private double balance;
	
	public void deposit(double amount) throws InvalidAmountException,NumberFormatException
	{
		if(amount < 0)
		{
			throw new InvalidAmountException("HDFC. Amount cannot be negative. Please Enter amount greater than 0.");
		}
		else
		{
			this.balance = this.balance + amount;
		}
	}
	
	public double withdraw(double amount) throws InvalidAmountException,InsufficientFundException,NumberFormatException
	{
		if(amount < 0)
		{
			throw new InvalidAmountException("HDFC. Amount cannot be negative. Please Enter amount greater than 0.");
		}
		else if(amount > balance)
		{
			throw new InsufficientFundException("HDFC. Available balance in account is less than requsted withdrawal Amount. Please Enter withdrawal valid amount.");
		}
		
		this.balance = this.balance - amount;
		
		return this.balance;
	}
	
	public void checkBalance()
	{
		System.out.println("HDFC. Available Balance = "+this.balance);
	}
}