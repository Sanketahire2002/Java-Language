class Array_2D
{
    public static void main(String[] args)
    {
        int[][] arr = new int[4][3];
        System.out.println( "Length of Rows of Array = "+arr.length);
        System.out.println( "Length of First row = "+arr[0].length);
        System.out.println( "Length of Second row = "+arr[1].length);
        System.out.println( "Length of Third row = "+arr[2].length);
        System.out.println( "Length of Fourth row = "+arr[3].length);

        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                arr[i][j] = i+j;

        for(int i=0;i<arr.length;i++)
        {    
            for(int j=0;j<arr[i].length;j++)
                System.out.print("  "+arr[i][j]);
            System.out.println();
        }

        System.out.println("----------------------------------------------------------");

        int[][] brr =   {
                            {10,20,30,40,50} ,
                            {11,22,33} ,
                            {-10},
                            {-1,-2,-3,-4,-5,-6,-7}
                        };

        System.out.println( "Length of Rows of Array = "+brr.length);
        System.out.println( "Length of First row = "+brr[0].length);
        System.out.println( "Length of Second row = "+brr[1].length);
        System.out.println( "Length of Third row = "+brr[2].length);
        System.out.println( "Length of Fourth row = "+brr[3].length);
        
        for(int i=0;i<brr.length;i++)
        {    
            for(int j=0;j<brr[i].length;j++)
                System.out.print("  "+brr[i][j]+"\t");
            System.out.println();
        }

        System.out.println("----------------------------------------------------------");

        int[][] crr;
        crr = new int[4][];
        crr[0] = new int[5];
        crr[1] = new int[3];
        crr[2] = new int[1];
        crr[3] = new int[7];
        for(int i=0;i<crr.length;i++)
        {    
            for(int j=0;j<crr[i].length;j++)
                System.out.print("  "+crr[i][j]+"\t");
            System.out.println();
        }

        System.out.println("----------------------------------------------------------");

        int[][] drr;
        drr = new int[4][];
        drr[0] = drr[1] = drr[2] = drr[3] = new int[7];
        for(int i=0;i<drr.length;i++)
        {    
            for(int j=0;j<drr[i].length;j++)
                System.out.print("  "+drr[i][j]+"\t");
            System.out.println();
        }

        System.out.println("----------------------------------------------------------");

        System.out.println("Printing 2D-Array using for-each loop.\n");
        for(int i=0;i<crr.length;i++)
        {    
            for(int x:crr[i])
                System.out.print("    "+x);
            System.out.println();
        }

        System.out.println("----------------------------------------------------------");

    }
}