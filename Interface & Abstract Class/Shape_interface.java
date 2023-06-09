import java.util.Scanner;

interface Shape
{
	void Area();
	void Perimeter();
}

class Circle implements Shape
{
	double pie=3.14;
	int r;
	double area;
	public Circle(int r)
	{
		this.r=r;
	}
	
	public void Area()
	{
		area=pie*r*r;
		System.out.println("Area of Circle is : "+area);
	}
	public void Perimeter()
	{
		double p=2*pie*r;
		System.out.println("Perimeter of Circle is : "+p);
	}
	
}

class Triangle implements Shape
{
	double area;
	int b;
	int h;
	public Triangle(int b,int h)
	{
		this.b=b;
		this.h=h;
	}
	public void Area()
	{
		area=1/2*(b*h);
		System.out.println("Area of Triangle : "+area);
	}
	
	public void Perimeter()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sides of triangle");
		int s1=b;
		System.out.println("Enter s2: "); 
		int s2=sc.nextInt();
		System.out.println("Enter s3: "); 
		int s3=sc.nextInt();
		
		int p=s1+s2+s3;
		System.out.println("Perimeter of Triangle : "+p);
	}
}

class Rectangle implements Shape
{
	int l;
	int b;
	public Rectangle(int l,int b)
	{
		this.l=l;
		this.b=b;
	}
	public void Area()
	{
		int area=l*b;
		System.out.println("Area of Rectangle is : "+area);
	}
	public void Perimeter()
	{
		int p=2*(l+b);
		System.out.println("Perimeter of Rectangle is : "+p);
	}
	
}

class Shape_interface
{
	public static void main(String args[])
	{
		Shape s;
		char choice;
		Scanner sc=new Scanner(System.in);
		
		do
		{
			
			System.out.println("1.Circle");
			System.out.println("2.Triangle");
			System.out.println("3.Rectangle");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter radius of Circle ");
					int r=sc.nextInt();
					s=new Circle(r);
					s.Area();
					s.Perimeter();
					break;
					
				case 2:
					System.out.println("Enter base: ");
					int b=sc.nextInt();
					System.out.println("Enter height: "); 
					int h=sc.nextInt();
		
					s=new Triangle(b,h);
					s.Area();
					s.Perimeter();
					break;
					
				case 3:
					s=new Rectangle(4,5);					
					s.Area();
					s.Perimeter();
					break;
					
			}
			System.out.println("Do you want to continue y or n? ");
			choice=sc.next().charAt(0);
		
		}while(choice=='y');
		
		
	}
}