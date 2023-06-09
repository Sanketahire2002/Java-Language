class Array_3D
{
    public static void main(String[] array)
    {
        int[][][] arr = new int[3][4][5];

        System.out.println("Rows of Array : "+arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.println("Elements in Row "+(i+1)+" : "+arr[i].length);

        int count = 1;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                for(int k=0;k<arr[i][j].length;k++)
                {
                    arr[i][j][k] = count;
                    count++;
                }
            }
        }

        System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.println("\t");
                for(int k=0;k<arr[i][j].length;k++)
                {
                    System.out.print("  "+arr[i][j][k]+"\t");
                } 
            }
            System.out.print("\n------------------------------------------");
        }
    }
}