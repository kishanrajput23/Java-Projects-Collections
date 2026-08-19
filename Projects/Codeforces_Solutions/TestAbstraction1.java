abstract class Shape 
{ 
abstract void draw(); 
} 
class Rect extends Shape 
{ 
void draw() 
{ 
System.out.println("drawing  rectangle"); 
} 
} 
class Circle1 extends Shape 
{ 
void draw() 
{ 
System.out.println("drawing  circle"); 
} 
} 
public class TestAbstraction1 
{ 
public static void main(String args[]) 
{ 
Rect s=new Rect(); 
s.draw(); 
} 
}

