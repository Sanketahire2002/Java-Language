class Parent
{
    int a = fun();

    {
        System.out.println("Parent Non Static Block");
    }

    int b = gun();

    Parent()
    {
        System.out.println("Parent Constructor");
    }

    int fun()
    {
        System.out.println("Parent Variable a");
        return 10;
    }

    int gun()
    {
        System.out.println("Parent Variable b");
        return 20;
    }
}

class Child extends Parent
{
    int x = run();
    
    {
        System.out.println("Child Non Static Block");
    }

    int y = sun();

    Child()
    {
        System.out.println("Child Constructor");
    }

    int run()
    {
        System.out.println("Child Variable x");
        return 10;
    }

    int sun()
    {
        System.out.println("Child Variable y");
        return 20;
    }
}

class Child_2 extends Child
{
    int p = done();
    
    {
        System.out.println("Child_2 Non Static Block");
    }

    int q = none();

    Child_2()
    {
        System.out.println("Child_2 Constructor");
    }

    int done()
    {
        System.out.println("Child_2 Variable p");
        return 10;  
    }

    int none()
    {
        System.out.println("Child_2 Variable q");
        return 10;  
    }

    public static void main(String[] args) throws Exception
    {
        Child_2 obj;
        obj = new Child_2();
    }
}