import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strings {

    public static void main(String[] args) {

        String s = "Harishankar Bhat R";
        String s1 = "Harishankar BhaT r";
        String s2 = "Hari";
        int num = 12345;
        String ss = Integer.toString(num);
        String a1 = "abc";
        String b1 = "abcd";
        String isnullorempty = "";


        System.out.println("Number -> String : " + ss);
        System.out.println("Printing string : " + s);
        System.out.println("Length of string s : " + s.length());
        System.out.println("Character at 2nd index : " + s.charAt(2));
        String a = "a";
        String A = "A";
        String b = "b";
        String B = "B";
        System.out.println("CompareTo : " + a.compareTo(b));
        System.out.println("CompareTo : " + A.compareTo(A));
        System.out.println("CompareTo : " + b.compareTo(a));
        System.out.println("CompareToIgnoreCase : " + s.compareToIgnoreCase(s1));
        System.out.println("Concat : " + s.concat(s1));
        System.out.println("Contains : " + b1.contains(a1));
        System.out.println("ContentEquals : " + s.contentEquals(s1));
        System.out.println("EndsWith : " + s.endsWith("R"));
        System.out.println("StartsWith : " + s.startsWith("H"));
        System.out.println("IndexOf : " + s.indexOf("a"));
        System.out.println("Intern : " + s.intern());
        System.out.println("LastIndexOf : " + s.lastIndexOf("a"));
        System.out.println("Replace : " + s1.replace("a","A"));
        System.out.println("ReplaceAll : " + s1.replaceAll("Hari", "abcd"));
        System.out.println("Split : " + Arrays.toString(s.split(" ")));
        System.out.println("SubString : " + s.substring(0,4));
        System.out.println("SubSequence : " + s.subSequence(0,5));
        System.out.println("ToLowerCase : " + s.toLowerCase() + " ToUpperCase : " + s.toUpperCase());
        System.out.println("ToString : " + s.toString());
        System.out.println("ValueOf : " + s.valueOf(2));
        if(isnullorempty.isEmpty())
        {
            System.out.println("isempty Yes");
        }
        else
        {
            System.out.println("isempty No");
        }
        if(isnullorempty == null || isnullorempty.isEmpty())
        {
            System.out.println("Null yes");
        }
        else
        {
            System.out.println("Null no");
        }

        String Aa = "hello";
        String Bb = "java";

        System.out.println(Aa.length() + Bb.length());
        System.out.println(Aa.compareTo(Bb)>0 ? "Yes" : "No");
        System.out.println(Aa.substring(0,1).toUpperCase()+Aa.substring(1,Aa.length())+ " " +
                Bb.substring(0,1).toUpperCase()+Bb.substring(1,Bb.length()));


        String small = "hello";
        String caps = "HELLO";

        System.out.println("EqualsIgnoreCase : " + small.equalsIgnoreCase(caps));

        String last9Digits = "12345123456789";
        System.out.println(last9Digits.substring(last9Digits.length()-9));
        String last = last9Digits.substring(last9Digits.length()-9);
        StringBuilder sb = new StringBuilder();
        sb.append(last.charAt(0));
        sb.append(last.charAt(6));
        sb.append(last.charAt(7));

        System.out.println(sb);

        System.out.println(sb.indexOf("7"));
    }
}
