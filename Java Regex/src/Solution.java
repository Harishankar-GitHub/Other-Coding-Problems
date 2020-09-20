import java.util.Scanner;

class Solution{

    // Link : https://www.hackerrank.com/challenges/java-regex/problem

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}