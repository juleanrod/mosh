package com.codewithmosh;
import java.util.HashMap;
import java.util.Stack;

public class BalanceChecker {

    public static boolean isBalanced(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        map.put('<', '>');

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(map.containsKey(current))
                stack.push(current);
            if (map.containsValue(current)) {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }

        }

        if(stack.isEmpty()) return true;
        return false;
    }
}
