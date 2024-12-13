//plss accept my pr, this cpde is for solving tower of hanoi problem

class Main {
 
  public static void main(String[] args) {
    hanoi(3, 'A', 'B', 'C');
  }
 
  private static void hanoi(int n, char rodFrom, char rodMiddle, char rodTo){
 
    if(n==1){
      System.out.println("Disk 1 moved from "+rodFrom+" to "+rodTo);
      return;
    }
 
    //Move top n-1 disks from A to B using C as middle
    hanoi(n-1,rodFrom,rodTo,rodMiddle);
 
    //Move last disk from A to C
    System.out.println("Disk "+n+" moved from "+rodFrom+" to "+rodTo);
 
    //Move n-1 disks from B to C using A as middle
    hanoi(n-1,rodMiddle,rodFrom,rodTo);
 
  }
}