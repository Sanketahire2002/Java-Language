class Constructor
{
    Constructor()
    {
        System.out.println("Default Constructor.");
    }

    Constructor(int a)
    {
        System.out.println("Parameterised Constructor.");
    }

    void Constructor()
    {
        System.out.println("Simple Method.");
    }

    public static void main(String args[])
    {
        System.out.println("Hello Sanket ...");
        Constructor t1 = new Constructor();
        Constructor t2 = new Constructor(10);
        t1.Constructor();
    }
}