// Program-5
// Non-Static / Normal Inner Class
// 

class Outer_5
{
	class Inner
	{
		static int a;
		static final int b = 10;
	}
	
	void gun()
	{
		Inner i2 = new Inner();
		System.out.println("a = "+i2.a+"\tb = "+i2.b);
	}
	
	public static void main(String[] args)
	{
		Outer_5 o = new Outer_5();
		Outer_5.Inner i = o.new Inner();
		System.out.println("a = "+i.a+"\tb = "+i.b);
		
		o.gun();
	}
}