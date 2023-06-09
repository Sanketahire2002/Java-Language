class Parent
{
    Parent()
    {
        this(10);   // Always write in first line of Constructor
        System.out.println("Parent Constructor");
    }

    Parent(int a)
    {
        this(5,10);
        System.out.println("Parent Parameterized Constructor");
    }

    Parent(int a,int b)
    {
        // this(5); Recursive call
        System.out.println("Parent Double Parameterized Constructor");
    }
}

class Constructor_3 extends Parent
{
    Constructor_3()
    {
        System.out.println("Child Constructor");
    }

    public static void main(String[] args)
    {
        new Constructor_3();
    }
}