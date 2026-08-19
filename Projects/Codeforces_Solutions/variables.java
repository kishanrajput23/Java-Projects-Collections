

public class variables
{  
    static int m=100;//static variable  
    void method()  
    {    
        int n=90;//local variable
        n=n+m; 
        System.out.println(n);   
    } 
    public static void main(String args[])  
    {
        int data=50;//instance variable
        variables obj=new variables();
obj.method();
        System.out.println(data);
        System.out.println(m);
    }
}