
class Dog extends Animal 
{ 
Dog() 
{ 

    super(); 
    System.out.println("dog is created"); 
} 
} 

class testsuper3
{ 
public static void main(String args[]) 
{ 
Dog d=new Dog(); 
d.getClass();
} 
}