// Program-3
// Non-Static / Normal Inner Class
// Accessing Inner class From Inside of Outer Class from Non-Static Context/Scope 

class Outer_3
{
	class Inner
	{
		void fun()
		{
			System.out.println("Inner Class.");
		}
	}
	
	void gun()
	{
		// Method-1
		Inner i = new Inner();
		i.fun();
		
		// Method-2
		new Inner().fun();
		
		// Method-3
		Outer_3 o = new Outer_3();
		Outer_3.Inner i2 = o.new Inner();
		i2.fun();
		
		// Method-4
		Outer_3.Inner i3 = new Outer_3().new Inner();
		i3.fun();
		
		// Method-5
		new Outer_3().new Inner().fun();
	}
	
	public static void main(String[] args)
	{
		Outer_3 o = new Outer_3();
		o.gun();
	}
}