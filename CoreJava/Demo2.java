import java.util.Scanner;
class Demo2
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string = ");

        String s = sc.nextLine();
        System.out.println("output = " +s);
        System.out.println("enter string = ");
        s = sc.next();
        System.out.println("output = " +s);
    }
}