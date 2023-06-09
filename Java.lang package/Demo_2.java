class Demo_2
{
    int a,b,c;

    Demo_2(int a,int b,int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String args[])
    {
        Demo_2 d1 = new Demo_2(10,20,30);
        String s = "Sanket";

        System.out.println("d1 = "+d1);
        System.out.println(s);      // Already overriden in String Class
        System.out.println(s.toString());

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
    
    public String toString()
    {
        return this.a+"\t"+this.b+"\t"+this.c;
    }

    public static void main(String[] args)
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------");

        Test t1 = new Test(10,20,30);
        Test t2 = new Test(70,80,90);

        System.out.println("Class Name of Object t1 ==> "+t1.getClass().getName());
        System.out.println("Hashcode in Hexadecimal Form of Object t1 ==> "+Integer.toHexString(t1.hashCode()));

        System.out.println("t1 According to Prototype of toString Method ==> "+t1.getClass().getName()+"@"+Integer.toHexString(t1.hashCode()));

        System.out.println(t1);
        System.out.println(t2.toString());
    }
}