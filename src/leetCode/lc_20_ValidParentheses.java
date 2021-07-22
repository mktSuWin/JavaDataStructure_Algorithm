package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
public class lc_20_ValidParentheses {
    public static void main(String[] args) {
        String s1 = "([)]";
        String s2 = "()[](({}))";
//        System.out.println(isValid_CharArray(s2));
        System.out.println(isValid_HashMap_Stack(s2));

    }

    // Using stack approach
    // Time O(n)
    // Space O(n)
    public static boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    // Using char array
    // ()[](({})
    // counter          |
    // Index    0   1   2   3   4   5   6   7   8
    // Time O(n)
    // Space O(n)
    public static boolean isValid_CharArray(String s){
        char[] stack = new char[s.length()]; // (
        int counter = 0;
        for(char c : s.toCharArray()){
            switch (c){
                case '(':
                    stack[counter++] = ')';
                    break;
                case '{':
                    stack[counter++] = '}';
                    break;
                case '[':
                    stack[counter++] = ']';
                    break;
                default:
                    if (counter == 0 || stack[--counter] != c)
                        return false;
                    break;
            }
        }
        return counter == 0;
    }

    // Third approach
    // Hashtable to take care of the map
    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    public static boolean isValid_HashMap_Stack(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                stack.push(map.get(c));
            }else if (map.containsValue(c)){
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/*

class Solution {
    // Hashtable to take care of the map
    private Map<Character, Character> map;

    public Solution(){
        this.map = new HashMap<Character, Character>();
        this.map.put('(', ')');
        this.map.put('[', ']');
        this.map.put('{', '}');
    }

    public boolean isValid(String s) {

       // HashMap<Character,Character> maps=new HashMap<Character,Character>();
       // maps.put(')','(');
       // maps.put(']','[');
       // maps.put('}','{');

 Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
                if (this.map.containsKey(c)){
                stack.push(map.get(c));
                }else if (map.containsValue(c)){
                if (stack.isEmpty() || stack.pop() != c){
                return false;
                }
                }
                }
                return stack.isEmpty();
                }
                }

 */
