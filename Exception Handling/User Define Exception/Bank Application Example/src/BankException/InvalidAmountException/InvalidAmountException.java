package BankException.InvalidAmountException;

import BankException.BankException;

public class InvalidAmountException extends BankException
{
	public InvalidAmountException()
	{
		super();
	}
	
	public InvalidAmountException(final String message)
	{
		super(message);
	}
}