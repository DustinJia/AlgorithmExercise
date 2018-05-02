package Execute;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<>();
        characters.add('1');
        characters.add('2');
        characters.add('3');

        String charStr = characters.toString();

        String serialized = charStr.substring(1, charStr.length() - 1);
        String[] valueStrings = serialized.split(", ");

        for (String str : valueStrings) {
            Integer value = new Integer(str);
            System.out.println(value);
        }
    }

}
