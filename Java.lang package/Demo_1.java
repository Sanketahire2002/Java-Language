class Demo_1
{
    int a,b,c;

    Demo_1(int a,int b,int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args)
    {
        Demo_1 d1 = new Demo_1(10,20,30);
        Demo_1 d2 = new Demo_1(50,60,70);
        Demo_1 d3 = new Demo_1(10,20,30);
        Demo_1 d4 = d1;

        System.out.print("d1 == d2 ==> ");
        System.out.println(d1 == d2);
        System.out.print("d1 == d3 ==> ");
        System.out.println(d1 == d3);

        System.out.println("d1 == d2 ==> "+d1.equals(d2));
        System.out.println("d1 == d3 ==> "+d1.equals(d3));

        System.out.println("d1 == d4 ==> "+d1.equals(d4));

        Test.main(null);

        /*
        Test t = new Test();
        System.out.println(d1==t);
        ------------------------------------------
        error: incomparable types: Demo_1 and Test
        System.out.println(d1==t);
        */
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

    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        else
        { 
            //if(this instanceof Test)
            if(o instanceof Test)
            {
                Test obj = (Test)o;
                return ((this.a == obj.a) && (this.b == obj.b) && (this.c == obj.c));
            }    
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------");

        Test t1 = new Test(10,20,30);
        Test t2 = new Test(70,80,90);
        Test t3 = new Test(10,20,30);

        Demo_1 d = new Demo_1(10,20,30);

        System.out.print("t1 == t2 ==> ");
        System.out.println(t1 == t2);
        System.out.print("t1 == t3 ==> ");
        System.out.println(t1 == t3);

        System.out.println("t1 == t2 ==> "+t1.equals(t2));
        System.out.println("t1 == t3 ==> "+t1.equals(t3));

        System.out.println("t1 == d ==> "+t1.equals(d));
    }
}