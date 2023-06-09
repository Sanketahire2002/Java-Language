class Demo_6
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
            System.out.println("Finally Block.");
        }

        System.out.println("End.");
    }
}