/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
import java.util.Arrays;
import static java.lang.System.*;
public class Solution {

    public class Array<E>{
        private E [] data;
        private int size;

        public Array(int capacity){
            this.data = (E[]) new Object[capacity];
            this.size = 0;
        }

        public Array(){
            this(16);
        }

        public void insert(E e, int ind){
            if (ind > data.length || ind < 0)
                throw new IllegalArgumentException("Index out of range!");
            if (size == data.length){
                resize(2 * data.length);
            }
            for (int i = size - 1; i >= ind; --i){
                data[i + 1] = data[i];
            }
            data[ind] = e;
            ++size;
        }

        public void insert(E e, int ind, int numbers){
            if (ind > data.length || ind < 0)
                throw new IllegalArgumentException("Index out of range!");
            if (numbers < 1)
                throw new IllegalArgumentException("number of insertion is less than 1.");
            if (size + numbers > data.length){
                resize((((size + numbers) / data.length) + 1) * data.length);
            }
            for (int i = size - 1; i >= ind; --i){
                data[i + numbers] = data[i];
            }
            for (int i = ind; i < ind + numbers; ++i){
                data[i] = e;
            }
            size += numbers;
        }
        
        public void insertFront(E e){
            insert(e, 0);
        }

        public void insertBack(E e){
            insert(e, size);
        }

        public int getSize(){
            return size;
        }

        public int getCapacity(){
            return data.length;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        @Override
        public String toString(){
            var buf = new StringBuilder(String.format("Array size : %d, capacity : %d\n[", size, data.length));
            for (int i = 0; i < size; ++i){
                buf.append(data[i]).append(", ");
            }
            buf.deleteCharAt(buf.length() - 1);
            buf.deleteCharAt(buf.length() - 1);
            buf.append("]");
            return buf.toString();
        } 

        public E getElement(int ind){
            E result;
            try {
                result = data[ind];
            } catch (ArrayIndexOutOfBoundsException ex){
                throw new IllegalArgumentException("Index out of range!");
            }
            return result;
        }

        public E getFirstElement(){
            return getElement(0);
        }
        
        public E getLastElement(){
            return getElement(size - 1);
        }



        public boolean replace(E e, int ind){
            var result = true;
            try {
                data[ind] = e;
            } catch (ArrayIndexOutOfBoundsException ex){
                result = false;
                throw new IllegalArgumentException("Index out of range!");
            }
            return result;
        }

        public int find(E e){
            for (int i = 0; i < size; ++i){
                if (e.equals(data[i])){
                    return i;
                }
            }
            return -1;
        }

        public E delete(int ind) {
            // assert ind >= size || ind < 0 : "Index out of range";
            E popData = null;
            try {
                popData = data[ind];
                if (size <= data.length / 3 && data.length / 2 != 0)
                resize(data.length / 2);
                for (int i = ind; i < size - 1; ++i){
                    data[i] = data[i + 1];
                }
                --size;
            } catch (ArrayIndexOutOfBoundsException ex){
                popData = null;
                throw new IllegalArgumentException("Index out of range!");
            }
            return popData;
        }
        
        public int delete(int start, int end) {
            int kills = end - start + 1;
            boolean exc = false;
            var tmp = Arrays.copyOf(data, data.length);
            try {
                if (size <= data.length / 3 && data.length / 2 != 0)
                    resize(data.length / 2);
                for (int i = start; i < size - kills; ++i){
                    tmp[i] = tmp[i + kills];
                }
                size -= kills;
            } catch (ArrayIndexOutOfBoundsException ex){
                exc = true;
                throw new IllegalArgumentException("Index out of range! The operation canceled.");
            }
            if (!exc){
                data = tmp;
                return kills;
            }
            return -1;
        }

        public E deleteFront(){
            return delete(0);
        }

        public E deleteBack(){
            return delete(size - 1);
        }

        public int findAndDelete(E e){
            if (delete(find(e)) != null)
                return 1;
            return 0;
        }

        public int findAndDeleteAll(E e){
            int cnt = 0;
            for (int i = 0; i < size; ++i){
                if (e.equals(data[i])){
                    data[i] = null;
                    ++cnt;
                }
            }
            for (int i = size - 1; i >= 0; --i){
                int kills = 0, ind = i;
                while (data[i] == null){
                    ++kills;
                    --i;
                }
                if (kills > 0)
                    delete(i + 1, ind);
            }
            return cnt;
        }

        public void resize(int newCapacity){
            var tmp = Arrays.copyOf(data, newCapacity);
            data = tmp;
        }
    }

    public interface Stack <E>{
        int getSize();
        boolean isEmpty();
        void push(E e);
        E pop();
        E peek();
    }

    public class ArrayStack<E> implements Stack<E>{ // 注意泛型使用
        Array<E> array;
    
        public ArrayStack(int capacity){
            array = new Array<E>(capacity);
        }
    
        public ArrayStack(){
            array = new Array<E>();
        }
    
        @Override
        public int getSize(){
            return array.getSize();
        }
    
        @Override
        public boolean isEmpty(){
            return array.isEmpty();
        }
    
        public int getCapacity(){ // 因為是以陣列實現，因此有此函數
            return array.getCapacity();
        }
    
        @Override
        public void push(E e){
            array.insertBack(e);
        }
    
        @Override
        public E pop(){
            return array.deleteBack();
        }
    
        @Override
        public E peek(){
            return array.getLastElement();
        }
    
        @Override
        public String toString(){
            var tmp = new StringBuilder("Stack :\n(bottom) [");
            for (int i = 0; i < array.getSize() - 1; ++i){
                tmp.append(array.getElement(i)).append(", ");
            }
            tmp.append(array.getElement(array.getSize() - 1)).append("] (top)");
            return tmp.toString();
        }
    }

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
// @lc code=end

