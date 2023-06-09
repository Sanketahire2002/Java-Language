package com.tcs.icici.loan.homeloan;
import com.tcs.icici.loan.carloan.Demo2;

class Test2 extends Demo2
{
	public static void main(String []args)
	{
		// We cannot use here ffully qualified path beacause we use Demo2 class already before that line
		System.out.println("a = "+a);
		Demo2.fun();
	}
}