class Parent
{
    static int a = fun();

    static
    {
        System.out.println("Parent Static Block");
    }

    static int b = gun();

    static int fun()
    {
        System.out.println("Parent Static Variable a");
        return 10;
    }

    static int gun()
    {
        System.out.println("Parent Static Variable b");
        return 20;
    }
}

class Child extends Parent
{
    static int x = run();

    static
    {
        System.out.println("Child Static Block");
    }

    static int y = sun();

    static int run()
    {
        System.out.println("Child Static Variable x");
        return 10;
    }

    static int sun()
    {
        System.out.println("Child Static Variable y");
        return 20;
    }
}

class Child_1 extends Child
{
    static int p = done();

    static
    {
        System.out.println("Child_1 Static Block");
    }

    static int q = none();

    static int done()
    {
        System.out.println("Child_1 Static Variable p");
        return 10;  
    }

    static int none()
    {
        System.out.println("Child_1 Static Variable q");
        return 10;  
    }

    public static void main(String[] args) throws Exception
    {
        Class.forName("Child_1");
    }
}