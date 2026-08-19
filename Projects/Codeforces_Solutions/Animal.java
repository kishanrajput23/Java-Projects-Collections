public class Animal
{ 
String name; 
void show() 
{ 
System.out.println("Animal Name is"+name); 
} 
} 
class Dog extends Animal 
{ 
void bark() 
{ 
System.out.println("Mother Dog Barking..."); 
} 
} 
class BabyDog extends Dog 
{ 
void weep() 
{ 
System.out.println("Baby Dog weeping"); 
} 
} 
class testInheritance
{ 
public static void main(String args[]) 
{ 
BabyDog d=new BabyDog(); 
d.name="MotherDog"; 
d.show(); 
d.bark(); 
d.weep(); 
} 
} 
