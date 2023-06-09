class Parent
{
    Parent()
    {
        System.out.println("Parent Constructor");
    }
}

class Parent_1 extends Parent
{
    Parent_1()
    {
        System.out.println("Parent_1 Constructor");
    }
}

class Parent_2 extends Parent_1
{
    Parent_2()
    {
        System.out.println("Parent_2 Constructor");
    }
}

class Constructor extends Parent_2
{
    Constructor()
    {
        System.out.println("Child Constructor");
    }

    public static void main(String[] args)
    {
        new Constructor();
    }
}