class Demo
{
	static
	{
		System.out.println("Demo Static Block");
	}
	
	public static void main(String[] z)
	{
		System.out.println("Demo Main Function");
	}
}

class Test 
{
	public static void main(String[] z)	throws ClassNotFoundException
	{
		Class.forName("Demo");
		System.out.println("Test Main Function");
	}
}