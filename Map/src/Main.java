import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//      Link : https://www.hackerrank.com/challenges/phone-book/problem

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();

        Map<String,Integer> mapp = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();

            mapp.put(name, phone);
        }

        while(in.hasNext())
        {
            String s=in.nextLine();
            if(mapp.get(s) != null) System.out.println(s+"="+mapp.get(s));
            else System.out.println("Not found");
        }
    }
}