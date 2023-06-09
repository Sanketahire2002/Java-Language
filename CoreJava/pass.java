import java.io.Console;
class pass
{
    public static void main(String[] ar)
    {
        Console c = System.console();
        char ch[] = c.readPassword();
        String str = String.valueOf(ch);
        System.out.println(str);
        System.out.println(c.readPassword());
    }
}