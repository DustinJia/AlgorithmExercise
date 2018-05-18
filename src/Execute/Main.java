package Execute;

public class Main {

    public static void main(String[] args) {
        int len = 2;
        String s = "abcd";
        String s1 = s.substring(0, len);
        String s2 = s.substring(len);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }
}
