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

class Test extends Demo
{
	public static void main(String[] z)
	{
		Demo d = new Demo();
		d.main(null);
		Demo.main(null);
		System.out.println("Test Main Function");
	}
}