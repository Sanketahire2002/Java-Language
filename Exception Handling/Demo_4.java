class Demo_4
{
	public static void main(String[] args)
	{
		int a = 5;
		try
		{
			a = 10 / 0;
		}
		catch(Exception e)
		{
			System.out.println("printStackTrace() ==>");
			e.printStackTrace();
			System.out.println("toString() ==>");
			System.out.println(e.toString());
			System.out.println("getMessage() ==>");
			System.out.println(e.getMessage());
			System.out.println("******************************");
			System.out.println("Exception Handled Successfully");
			System.out.println("******************************");
		}
	}
}

/*

java.lang.ArithmeticException: / by zero
	at Demo_4.main(Demo_4.java:8)
******************************
Exception Handled Successfully
******************************	
	
*/
