// Program-1
// Non-Static / Normal Inner Class
// Accessing Inner class From Outside of Outer Class

class Outer
{
	class Inner
	{
		void fun()
		{
			System.out.println("Inner Class.");
		}
	}
}

class Outer_1
{
	public static void main(String[] args)
	{
		// Method-1
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		i.fun();
		
		// Method-2
		Outer.Inner i2 = new Outer().new Inner();
		i2.fun();
		
		// Method-3
		new Outer().new Inner().fun();
	}
}