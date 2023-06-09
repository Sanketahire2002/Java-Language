/*
Exception in thread "main" java.lang.CloneNotSupportedException: Demo_4
        at java.lang.Object.clone(Native Method)
        at Demo_4.main(Demo_4.java:21)
*/

class Demo_4 implements Cloneable
{
    int a,b,c;

    Demo_4(int a,int b,int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString()
    {
        return this.a+"\t"+this.b+"\t"+this.c;
    }

    // error: unreported exception CloneNotSupportedException; must be caught or declared to be thrown
    public static void main(String[] args)  throws CloneNotSupportedException
    {
        Demo_4 d1 = new Demo_4(10,20,30);
        Demo_4 d2 = (Demo_4)d1.clone();     // error: incompatible types: Object cannot be converted to Demo_4

        System.out.println("Object d1 ==>   "+d1);
        System.out.println("Object d2 ==>   "+d2);

        Test.main(null);
    }
}

class Test extends Demo_4
{
    int a,b,c;

    Test(int a,int b,int c)
    {
        super(1,2,3);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString()
    {
        return this.a+"\t"+this.b+"\t"+this.c+"\t"+super.a+"\t"+super.b+"\t"+super.c;
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        Test t1 = new Test(11,22,33);
        Test t2 = (Test)t1.clone();

        System.out.println("Object t1 ==>   "+t1);
        System.out.println("Object t2 ==>   "+t2);
    }
}