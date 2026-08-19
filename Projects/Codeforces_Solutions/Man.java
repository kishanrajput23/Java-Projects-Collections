import java.util.ArrayList;
import java.util.List;

public class Man {
    public static void main(String[] args) {
        String s = "K1:L2";
        List<String> li = new ArrayList<>();

        char startChar = s.charAt(0);
        char endChar = s.charAt(3);

        int startNum = Integer.parseInt(s.charAt(1) + "");
        int endNum = Integer.parseInt(s.charAt(4) + "");

        for (char ch = startChar; ch <= endChar; ch++) {
            for (int a = startNum; a <= endNum; a++) {
                String ans = ch + "" + a;
                System.out.println(ans);
                li.add(ans);
            }
        }

        System.out.println(li);
    }
}
