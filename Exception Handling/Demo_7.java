class Demo_7
{
	public static void main(String[] args)
	{
        int a = 0;
        try
        {
            a = 10 / 0;
        }
        catch(Exception e)
        {
            System.out.println("Arithmatic Exception");
        }
        finally
        {
            System.out.println("Finally Block 1.");
        }

        System.out.println("-----------------------------------------");

        try
        {
            a = 10 / 0;
        }
        finally
        {
            System.out.println("Finally Block 2.");
        }

        System.out.println("End.");
    }
}