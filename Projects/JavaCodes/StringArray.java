public class StringComparison {  
 public static void main(String a[]){  
            String str = "JavaTpoint is a great website to acquire knowledge";  
                StringBuffer obj =  
            new StringBuffer("JavaTpoint is a great website to acquire knowledge");  
        if(str.contentEquals(obj)){  
            System.out.println("The content of the string is equal");  
        } else {  
            System.out.println("The content of the string is not equal");  
        }  
        StringBuffer obj1 =  
            new StringBuffer("It is another string");  
        if(str.contentEquals(obj1)){  
            System.out.println("The content of the string is equal");  
        } else {  
            System.out.println("The content of the string is not equal");  
        }  
    }  
}  
