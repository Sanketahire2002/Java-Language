import java.io.InputStreamReader;
import java.io.BufferedReader;
class Demo10
{
    public static void main(String args[]) throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);            
        System.out.println("Enter name");    
        String name=br.readLine();    
        System.out.println("string =  "+name);  
        //int a = Integer.parseInt(name);
        //System.out.println("a =  "+a); 
    }
}