class Parent
{
    void fun()
    {
        System.out.println("Parent fun Method");
    }
}

class This_3 extends Parent
{
    void fun()
    {
        System.out.println("Child fun Method");
    }

    void gun()
    {
        fun();
        super.fun();
    }

    public static void main(String[] args)
    {
        new This_3().gun();
    }
}