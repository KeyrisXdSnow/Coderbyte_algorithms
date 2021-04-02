import java.util.*;

class Main {

    public static String GroupTotals(String[] strArr) {
        SortedMap<String, Integer> map = new TreeMap<>();

        for (String entry : strArr) {
            String[] kv = entry.split(":");

            int value = Integer.parseInt(kv[1]);
            if (value != 0) {
                if (map.containsKey(kv[0])) map.replace(kv[0], map.get(kv[0])+value);
                else map.put(kv[0], value);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }


    public static String FindIntersection(String[] strArr) {
        String[] str1 = strArr[0].split(", ");
        String[] str2 = strArr[1].split(", ");
        StringBuilder result = new StringBuilder();

        int len = Math.min(str1.length, str2.length);


        int v1, v2 ;
        for (int j=0, i=0; i<str1.length && j<str2.length;) {

            v1 = Integer.parseInt(str1[i]);
            v2 = Integer.parseInt(str2[j]);

            if (v1 == v2) {
                result.append(v1).append(",");
                i++;
                j++;
            } else {
                if (v1 > v2) {
                    j++;
                } else {
                    i++;
                }
            }


        }

        if (result.isEmpty()) return "false";

        result.setLength(result.length()-1);
        return result.toString();
    }


    private static boolean isDigit(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': {
                return true;
            }
            default:
                return false;
        }
    }

    public static String QuestionsMarks(String str) {

        boolean isFind = false;
        String result = Boolean.FALSE.toString();
        int questions = 0;
        for (int i=0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            if (isDigit(str.charAt(i))) {
                if (isFind) {
                    if (questions < 3) return Boolean.FALSE.toString();

                    questions = 0;
                    result = Boolean.TRUE.toString();

                } else isFind = true;
            } else {
                if (isFind && str.charAt(i) == '?') questions++;
            }
        }
        if (questions != 0) return Boolean.FALSE.toString();
        return result;
    }

    public static String BracketMatcher(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            switch (str.charAt(i)){
                case '(': {
                    stack.push('(');
                    break;
                }
                case ')':{
                    if (!stack.isEmpty()) stack.pop();
                    else return "0";
                    break;
                }
            }
        }
        if (stack.isEmpty()) return "1";
        return "0";
    }

    public static void main(String[] args) {
        System.out.println(BracketMatcher("()coderbyte() yes()"));
    //    System.out.println(QuestionsMarks("5??aaaaaaaaaaaaaaaaaaa?5?5"));
        //System.out.println(FindIntersection(new String[] {"21, 22, 23, 25, 27, 28", "21, 24, 25, 29"}));
 //       System.out.println(GroupTotals(new String[]{"P:1", "N:1", "Z:1", "P:0", "N:-2", "Z:-1"}));
    }
}


