// Program-8
// Autoboxing & Autounboxing

class Wrapper_8
{
    public static void main(String[] args)
    {
        Wrapper_8 w1 = new Wrapper_8();
        Wrapper_8 w2 = new Wrapper_8();
        System.out.println(w1 == w2);

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1 == i2);

        Integer iobj1 = 10;
        Integer iobj2 = 10;
        System.out.println(iobj1 == iobj2);

        Integer iobj3 = 1000;
        Integer iobj4 = 1000;
        System.out.println(iobj3 == iobj4);
    }
}