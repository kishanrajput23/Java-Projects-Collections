import java.util.Scanner;  
//This class will calculate the max and min values of the array  
class TestArray  
{  
    int MAX(int[]Arry)  
    {  
        int maxValue= Arry[0];  
        for(int i=1;i<Arry.length;i++)  
        {  
            if(Arry[i]>maxValue)  
            {  
                maxValue=Arry[i];  
            }  
        }  
        return maxValue;//This method will return the max value present in the array.  
    }  
    int MIN(int[]Arry) {
        // ...existing code...
    }
}
