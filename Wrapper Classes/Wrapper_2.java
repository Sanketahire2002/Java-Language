// Program-2
// Conversion between   Object Type -->  Primitive Type

class Wrapper_2
{
    public static void main(String[] args)
    {
        Integer obj = Integer.valueOf("10");
		System.out.println(obj);

        int a = obj.intValue();
        System.out.println(a);
    }
}