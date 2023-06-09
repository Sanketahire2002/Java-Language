class Demo_3
{
    int a,b,c;

    Demo_3(int a,int b,int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String args[])
    {
        Demo_3 d1 = new Demo_3(10,20,30);
        Demo_3 d2 = new Demo_3(10,20,30);
        Demo_3 d3 = new Demo_3(10,20,30);
       
        System.out.println("System Hashcode for Object d1 = "+d1.hashCode());
        System.out.println("System Hashcode for Object d2 = "+d2.hashCode());
        System.out.println("System Hashcode for Object d3 = "+d3.hashCode());
        
        System.out.println("Hashcode for Object d1 by using System.identifyHashCode Method = "+System.identityHashCode(d1));
        System.out.println("Hashcode for Object d2 by using System.identifyHashCode Method = "+System.identityHashCode(d2));
        System.out.println("Hashcode for Object d3 by using System.identifyHashCode Method = "+System.identityHashCode(d3));
        Test.main(null);
    }
}

class Test
{
    int a,b,c;

    Test(int a,int b,int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int hashCode()
    {
        return this.a+this.b+this.c;
    }

    public static void main(String[] args)
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------");

        Test t1 = new Test(10,20,30);
        Test t2 = new Test(70,80,90);
        Test t3 = new Test(10,20,30);

        System.out.println("Hashcode for Object t1 = "+t1.hashCode());
        System.out.println("Hashcode for Object t2 = "+t2.hashCode());
        System.out.println("Hashcode for Object t3 = "+t3.hashCode());

        System.out.println("Hashcode for Object t1 by using System.identifyHashCode Method = "+System.identityHashCode(t1));
        System.out.println("Hashcode for Object t2 by using System.identifyHashCode Method = "+System.identityHashCode(t2));
        System.out.println("Hashcode for Object t3 by using System.identifyHashCode Method = "+System.identityHashCode(t3));
    }
}