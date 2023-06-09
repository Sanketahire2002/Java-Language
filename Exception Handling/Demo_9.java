class Demo_9
{
    void fun()
    {

    }

    public static void main(String[] args)
    {
        Demo_9 d = null;

        if(d == null)
        {
            throw new NullPointerException("d must be initialised.");
        }
        else
            d.fun();
    }
}

/*
Exception in thread "main" java.lang.NullPointerException: d must be initialised.
        at Demo_9.main(Demo_9.java:14)

If we only do
throw new NullPointerException();
then ==>
Exception in thread "main" java.lang.NullPointerException
        at Demo_9.main(Demo_9.java:14)
*/