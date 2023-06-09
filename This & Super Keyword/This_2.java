class Parent
{
    void fun()
    {
        System.out.println(this);
    }
}

class This_2 extends Parent
{
    void gun()
    {
        System.out.println(this);
    }

    public static void main(String[] args)
    {
        This_2 obj = new This_2();
        obj.gun();
        obj.fun();
    }
}