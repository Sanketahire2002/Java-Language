class sta4
{
    void fun()
    {
        System.out.println("fun Function");
        sta4.gun();
    }

    static void gun()
    {
        System.out.println("gun Function");
    }

    public static void main(String[] a)
    {
        new sta4().fun();
    }
}