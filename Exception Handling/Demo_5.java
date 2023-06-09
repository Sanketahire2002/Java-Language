class Demo_5
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println(Integer.parseInt(args[0]) / Integer.parseInt(args[1]));
		}		
		catch(ArrayIndexOutOfBoundsException ai)
		{
			System.out.println("Array Index is out of Bounds Exception Occurs and Handled.");
		}
		catch(NumberFormatException ne)
		{
			System.out.println("Number Format Exception Occurs and Handled.");
		}
		/*catch(ArithmeticException ae)
		{
			System.out.println("Arithmetic Exception is Occurs and Handled.");
		}*/
		catch(Throwable t)
		{
			System.out.println("*************************************");
			System.out.println("Generic Exception Caught and Handled.");
			t.printStackTrace();
			System.out.println("*************************************");
		}
	}
}

/*
When we write catch block from paren to child hierachy

Demo_5.java:13: error: exception ArrayIndexOutOfBoundsException has already been caught


(base) design@design-HP-Pro-3330-MT:~/Downloads$ java Demo_5
Array Index is out of Bounds Exception Occurs and Handled.

(base) design@design-HP-Pro-3330-MT:~/Downloads$ java Demo_5 10 a
Number Format Exception Occurs and Handled.

(base) design@design-HP-Pro-3330-MT:~/Downloads$ java Demo_5 10 0
*************************************
Generic Exception Caught and Handled.
java.lang.ArithmeticException: / by zero
	at Demo_5.main(Demo_5.java:7)
*************************************


------------------------------------------------------------------------------------------
catch(Object tp)
{
	System.out.println("Generic Exception Caught and Handled.");
	//tp.printStackTrace();
}
		
(base) design@design-HP-Pro-3330-MT:~/Downloads$ javac Demo_5.java
Demo_5.java:21: error: incompatible types: Object cannot be converted to Throwable
		catch(Object tp)
		      ^
1 error

*/

