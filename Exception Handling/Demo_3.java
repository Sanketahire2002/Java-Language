class Demo_3
{
	void fun()
	{
		gun();
	}
	
	void gun()
	{
		run();
	}
	
	void run()
	{
		sun();
	}
	
	void sun()
	{
		int c = 10 / 0;
	}
	
	public static void main(String[] args)
	{
		Demo_3 d = new Demo_3();
		d.fun();
	}
}

/*

Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Demo_3.sun(Demo_3.java:20)
	at Demo_3.run(Demo_3.java:15)
	at Demo_3.gun(Demo_3.java:10)
	at Demo_3.fun(Demo_3.java:5)
	at Demo_3.main(Demo_3.java:27)
	
Name of Exception ==>  java.lang.ArithmeticException
Description of Exception  ==> / by zero
Location of Exception by Stack Trace ==> sun->run->gun->fun->main
	at Demo_3.sun(Demo_3.java:20)
	at Demo_3.run(Demo_3.java:15)
	at Demo_3.gun(Demo_3.java:10)
	at Demo_3.fun(Demo_3.java:5)
	at Demo_3.main(Demo_3.java:27)

*/
