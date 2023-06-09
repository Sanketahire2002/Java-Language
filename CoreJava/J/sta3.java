class Demo
{
	int a = fun();
	int b = gun();
	// static int a = fun();
	
	static int fun()
	{
		System.out.println("fun() Function");
		return 5;
	}
	
	int gun()
	{
		System.out.println("fun() Function");
		return 11;
	}
	
	public static void main(String args[])
	{
		Demo d = new Demo();
		System.out.println("Main Function\ta = "+d.a+"\tb = "+d.b);
	}
}