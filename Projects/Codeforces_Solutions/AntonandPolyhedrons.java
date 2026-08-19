import java.util.*;

public class AntonandPolyhedrons {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int ans=0;
        while(t--!=0)
        {
            String s=sc.next();
            switch (s) {
                case "Tetrahedron":
                    ans+=4;
                    break;
                case "Cube":
                    ans+=6;
                    break;
                case "Octahedron":
                    ans+=8;
                    break;
                case "Dodecahedron":
                    ans+=12;
                    break;
                case "Icosahedron":
                    ans+=20;
                    break;
                default:
                    break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
