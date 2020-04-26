package jAVA;

//import com.sun.java.util.jar.pack.Package.File;

public class appium1 {

	public static void main(String []args){
        int abc[][]={{6,9,4},{0,1,6},{7,10,11}};
        int min=abc[0][0];
        int mincolumn = 0;
        
        for (int i=0;i<2;i++)
        {
            for (int j=0;j<2;j++)
            {
                if(abc[i][j]<min)
                {
                    min=abc[i][j];
                    mincolumn=j;
                }
            }
        }
        int max= abc[0][mincolumn];
        int k=0;
        while (k<3)
        {
            if(abc[k][mincolumn]>max)
            {
                max=abc[k][mincolumn];
            }
            k++;
        }
        
        
        System.out.println(max);
     }

}
