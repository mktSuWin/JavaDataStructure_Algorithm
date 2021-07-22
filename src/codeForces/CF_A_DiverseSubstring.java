package codeForces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 */
public class CF_A_DiverseSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int sLength = sc.nextInt();
//         char[] input = new char[sLength];
//        for(int i = 0; i < sLength; i++){
//
//        }
//         String s = input.toString();

        String s = sc.next();
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                String something = s.substring(i, j);
                if(isDiverse(something)){
                    System.out.println("YES");
                    System.out.println(something);
                    return;
                }
            }
        }
        System.out.println("NO");

    }
    // c o d e
    // c 2
    // c 1
    public static boolean isDiverse(String a){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            char aI = a.charAt(i);
            if(map.containsKey(aI)){
                map.put(aI, map.get(aI)+1);
            } else{
                map.put(aI, 1);
            }
            if(map.get(aI) > a.length()/2){
                return false;
            }
        }
//        System.out.println(a);
//        System.out.println(map.toString());
        return true;
    }
}

/*
    public static void main(String[] args) {
        Scanner inputReceiver = new Scanner(System.in);
        int N = inputReceiver.nextInt(); String s = inputReceiver.next(); boolean isAnswerFound = false;
        for (int i = 0; i < N - 1; i ++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                System.out.println("YES");
                System.out.println(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)));
                isAnswerFound = true;
                break;
            }

        }
        if (!isAnswerFound) {
            System.out.println("NO");
        }
    }



    	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		String s=in.next();
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i)!=s.charAt(i+1))
			{
				System.out.println("YES");
				System.out.print(s.charAt(i));
				System.out.print(s.charAt(i+1));
				System.exit(0);
			}
		}
		System.out.println("NO");
	}

	    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String res = "";
        for (int i = 1; i < n; i++) {
            if(s.charAt(i)!= s.charAt(i-1)){
                res = res+s.charAt(i-1)+s.charAt(i);
                break;
            }
        }
        if(res.isEmpty()){
            System.out.println("NO");
        }else {
            System.out.println("YES");
            System.out.println(res);
        }
    }

 */