//Program to validate any ATM card.
import java.util.Scanner; 

class ATM_CARD_VALIDATOR{
    public static boolean TwoDigit(int n) {
        int i=0; 
        i+=n/10; 
        if(i>=1)
        return true;
        else   
        return false;
        } 
    public static void main(String args[]){
        int[] cnum = new int[16];
        int x=0,y=0; 
        try (Scanner scn = new Scanner(System.in)) {
            for(int i=0;i<16;i++) 
            {
                if(i+1==1){
                    System.out.println("Enter the " + (i+1) +"st digit of the card:");
                    cnum[i] = scn.nextInt();
                    }        
                else if(i+1==2) { 
                    System.out.println("Enter the " + (i+1) +"nd digit of the card:");
                    cnum[i] = scn.nextInt();       
                    }       
                else if(i+1==3) {     
                    System.out.println("Enter the " + (i+1) +"3rd digit of the card:");
                    cnum[i] = scn.nextInt();     
                    }        
                else{     
                    System.out.println("Enter the " + (i+1) +"th digit of the card:");
                    cnum[i] = scn.nextInt();
                    }     

            }
        }
    for(int i=cnum.length-2;i>=1;i=i-2)   
    {        
        cnum[i+1]+=cnum[i-1]*2;  
        if(TwoDigit(cnum[i+1])){     
            cnum[i+1]=cnum[i+1]-9; 
            }             
    }    
    for(int i=0;i<16;i=i+2)  
    {     
        y+=cnum[i];    
    }   
    if((x+y)%2==0){      
        System.out.println("The CARD is Valid");
    }   
    else{
        System.out.println("The CARD is Not Valid");
    }
}
}
