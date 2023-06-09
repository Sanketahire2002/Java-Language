// Program-4
// Non-Static / Normal Inner Class
// Accessing Data Member of Outer Class into Inner Class
// Accessing Data Member of Inner Class into Outer Class by using Object of Inner Class

class Outer_4
{
	int a;
	class Inner
	{
		int b;
		void fun()
		{
			System.out.println("a = "+a);
		}
	}
	
	public static void main(String[] args)
	{
		// Accessing Data Member of Outer Class into Inner Class
		Outer_4 o = new Outer_4();
		Outer_4.Inner i = o.new Inner();
		i.fun();
		
		// Accessing Data Member of Inner Class into Outer Class by Using Object of Inner Class
		System.out.println("b = "+i.b);
	}
}