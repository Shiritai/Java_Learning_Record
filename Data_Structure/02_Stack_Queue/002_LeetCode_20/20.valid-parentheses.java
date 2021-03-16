/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
import java.util.Stack;

public class Solution {
    public boolean isValid(String s){
        var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i){
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{')
                stack.push(tmp);
            else {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();
                if (tmp == ')' && top != '(')
                    return false;
                if (tmp == ']' && top != '[')
                    return false;
                if (tmp == '}' && top != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

