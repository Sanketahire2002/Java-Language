package BankException.InsufficientFundException;

import BankException.BankException;

public class InsufficientFundException extends BankException
{
	public InsufficientFundException()
	{
		super();
	}
	
	public InsufficientFundException(final String message)
	{
		super(message);
	}
}