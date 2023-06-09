class Demo_1
{
	public static void main(String[] args)
	{
		System.out.println(Integer.parseInt(args[0]) / Integer.parseInt(args[1]));
	}
}

/*

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0	at Demo_1.main(Demo_1.java:5)


Exception in thread "main" java.lang.NumberFormatException: For input string: "a"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.base/java.lang.Integer.parseInt(Integer.java:652)
	at java.base/java.lang.Integer.parseInt(Integer.java:770)
	at Demo_1.main(Demo_1.java:5)


Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Demo_1.main(Demo_1.java:5)

*/
