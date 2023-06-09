class Parent
{
    int b = 100;
}
class Parent_1 extends Parent
{
    int a = 10;
}

class This_1 extends Parent_1
{
    int a = 20;

    void fun()
    {
        int a = 30;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);

        System.out.println(super.b);
        System.out.println(this.b);
    }

    public static void main(String[] args)
    {
        new This_1().fun();
        // this.a & super.a Not Allowed in Static Context
    }
}