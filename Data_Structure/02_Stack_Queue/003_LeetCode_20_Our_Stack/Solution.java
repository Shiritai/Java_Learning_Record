public class Solution {
    public boolean isValid(String s){
        var stack = new ArrayStack<Character>();
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

    /* Test method */
    public static void main(String[] args){
        System.out.println((new Solution()).isValid("()"));
        System.out.println((new Solution()).isValid("({})}"));
    }
}