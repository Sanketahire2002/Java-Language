class Demo
{
    public static void main(String args[])
    {
        System.out.print("Array : ");
		for(int i=0;i<args.length;i++)
			System.out.print("   "+args[i]);
		
		System.out.println("\n"+Integer.parseInt(args[0]));
		System.out.println(Float.parseInt(args[0]));
    }
}