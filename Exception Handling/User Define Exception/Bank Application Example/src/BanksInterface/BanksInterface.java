package BanksInterface;

import BankException.InsufficientFundException.InsufficientFundException;
import BankException.InvalidAmountException.InvalidAmountException;

public interface BanksInterface
{
	void deposit(double amt) throws InvalidAmountException,NumberFormatException;
	
	double withdraw(double amt) throws InvalidAmountException,InsufficientFundException,NumberFormatException;
	
	void checkBalance();	
}