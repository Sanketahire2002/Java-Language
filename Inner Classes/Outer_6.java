// Program-6
// Method Local Inner Class

class Outer_6
{
    class NormalInner
    {
        static int d;
    }

    
    public static void main(String[] args)
    {
        Outer_6 o = new Outer_6();
        Outer_6.NormalInner i = o.new NormalInner();
    }
}