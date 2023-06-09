class Parent
{
    Parent()
    {
        System.out.println("Parent Constructor");
    }

    Parent(int a)
    {
        System.out.println("Parent Parameterized Constructor");
    }
}

class Constructor_2 extends Parent
{
    Constructor_2()
    {
        super(10);      // Always write in first line of Constructor
        System.out.println("Child Constructor");
    }

    public static void main(String[] args)
    {
        new Constructor_2();
    }
}