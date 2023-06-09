// Program-2
// Non-Static / Normal Inner Class
// Accessing Inner class From Inside of Outer Class from Static Context/Scope 

class Outer_2
{
	class Inner
	{
		void fun()
		{
			System.out.println("Inner Class.");
		}
	}
	
	public static void main(String[] args)
	{
		// Method-1
		Outer_2 o = new Outer_2();
		Outer_2.Inner i = o.new Inner();
		i.fun();
		
		// Method-2
		Outer_2.Inner i2 = new Outer_2().new Inner();
		i2.fun();
		
		// Method-3
		new Outer_2().new Inner().fun();
	}
}