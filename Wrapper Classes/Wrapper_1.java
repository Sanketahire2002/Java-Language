// Program-1
// Conversion between   Primitive Type --> Object Type

class Wrapper_1
{
    public static void main(String[] args)
    {
        // Method-1
		Integer iobj1 = new Integer(10);
		System.out.println(iobj1);
		
        // Method-2
		Integer iobj2 = Integer.valueOf(10);
		System.out.println(iobj2);

        // Method-3
        Integer iobj3 = new Integer("10");
		System.out.println(iobj3);

        // Method-4
        Integer iobj4 = Integer.valueOf("10");
		System.out.println(iobj4);

        // toString() in Object Override
        Wrapper_1 w = new Wrapper_1();
        System.out.println(w);

        Character c = new Character('A');
        System.out.println(c);

        Character c2 = Character.valueOf('B');
        System.out.println(c2);

        /*
        Character c3 = Character.valueOf("Q");
        System.out.println(c3);

        Character c4 = new Character("V");
        System.out.println(c4);
        */
    }
}