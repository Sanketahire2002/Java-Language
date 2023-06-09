// Program-7
// Static Nested Class

class Outer_8
{
	static int a;
	// int a;
    static class Inner                  // Run by   Outer_8$Inner   name.
    {
        public static void main(String[] args)
        {
            System.out.println("Inner Nested Class\ta = "+a);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Outer class");
    }
}