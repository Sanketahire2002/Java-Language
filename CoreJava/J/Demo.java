class Demo
{
    static int a = fun();

    static int fun()
    {
        System.out.println("Static Function");
        return 5;
    }

    public static void main(String[] args)
    {
        System.out.println("Main Class");
    }

    static
    {
        System.out.println("Static Block");
    }
}