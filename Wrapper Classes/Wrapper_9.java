// Program-9
// Winding

class Wrapper_9
{
    void fun(int i)
    {
        System.out.println("Primitive Type int i");
    }

    void fun(Integer i)
    {
        System.out.println("Object Type Integer i");
    }

    void fun(long i)
    {
        System.out.println("Higher Primitive Type Integer i");
    }

    void fun(Long i)
    {
        System.out.println("Higher Object Type Integer i");
    }

    public static void main(String[] args)
    {
        int i = 100;
        Integer iobj = new  Integer(i);
        Wrapper_9 w = new Wrapper_9();
        w.fun(i);
        w.fun(iobj);
    }
}