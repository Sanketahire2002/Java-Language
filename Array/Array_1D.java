import java.util.Arrays;
class Array_1D
{
    public static void main(String[] args)
    {
        int arr[];
        arr = new int[5];
        int brr[] = new int[10];
        int[] crr;
        int drr[] = {30,10,40,50,20};
        System.out.print("Array : ");
        for(int i=0;i<drr.length;i++)
            System.out.print("   "+drr[i]);
        System.out.print("\nArray : ");
        for(int x : drr)
            System.out.print("   "+x);
        Arrays.toString(drr);
        System.out.print( "\nArray : "+Arrays.toString(drr));
        int max,min;
        min = max= drr[0];
        for(int i=0;i<drr.length;i++)
        {
            if(min>drr[i])
                min = drr[i];
            if(max<drr[i])
                max = drr[i];
        }
        System.out.print( "\nMax : "+max+"    Min : "+min);
        Arrays.sort(drr);
        System.out.println( "\nArray : "+Arrays.toString(drr));
        System.out.println(Arrays.binarySearch(drr,30));
        System.out.println(Arrays.binarySearch(drr,55));
        System.out.println(Arrays.binarySearch(drr,1,5,30));
        System.out.println(Arrays.binarySearch(drr,1,5,55));
        int err[];
        err = new int[5];
        err[0]=10;
        err[1]=20;
        err[2]=30;
        for(int x : err)
            System.out.print("   "+x);
        // drr[6]=88;
        // int err[] = new int[-5];
    }
}