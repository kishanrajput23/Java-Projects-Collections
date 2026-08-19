class ParentClass{ 
  
        int num = 10; 
         
        final void showata() { 
         System.out.println("Inside ParentClass showData() method"); 
         System.out.println("num = " + num); 
        } 
         
       } 
        
       class ChildClass extends ParentClass{ 
         
        void showData() { 
         System.out.println("Inside ChildClass showData() method"); 
         System.out.println("num = " + num); 
        } 
       } 
        
       public class FinalKeywordExampl { 
        
        public static void main(String[] args) { 
          
         ChildClass obj = new ChildClass(); 
         obj.showData(); 
         obj.showata(); 
          
        } 
       } 

