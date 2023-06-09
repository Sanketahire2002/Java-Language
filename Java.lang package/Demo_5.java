class Test implements Cloneable
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

    // error: unreported exception CloneNotSupportedException; must be caught or declared to be thrown
    // error: clone() has protected access in Object
    public Test clone() throws CloneNotSupportedException
    {
        return (Test)super.clone();
    }

}

class Demo_5 
{
    // error: unreported exception CloneNotSupportedException; must be caught or declared to be thrown
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Test t1 = new Test(10,20,30);
        Test t2 = t1.clone();     // error: incompatible types: Object cannot be converted to Demo_5

        System.out.println("Object t1 ==>   "+t1);
        System.out.println("Object t2 ==>   "+t2);
    }
}