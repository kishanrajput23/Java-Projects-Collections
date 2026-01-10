class A  
{  
   public void methodA() {  
      System.out.println("method of Class A");  
   }  
}  
class B extends A{  
   public void methodB(){  
      System.out.println("method of Class B");  
   }  
}  
class C extends A{  
  public void methodC(){  
     System.out.println("method of Class C");  
  }  
}  
class D extends A{  
  public void methodD(){  
     System.out.println("method of Class D");  
  }  
}  
class InheritncExm{  
  public static void main(String args[])  
  {  
     B obj1 = new B();  
     C obj2 = new C();  
     D obj3 = new D();  
     //All classes can access the method of class A  
     obj1.methodA();  
     obj2.methodA();  
     obj3.methodA();  
  }  
}  
